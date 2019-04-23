/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gridgain.hcdemo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gridgain.hcdemo.model.Application;
import com.gridgain.hcdemo.model.Bureau;
import com.gridgain.hcdemo.model.BureauBalance;
import com.gridgain.hcdemo.model.CreditCardBalance;
import com.gridgain.hcdemo.model.InstallmentPayment;
import com.gridgain.hcdemo.model.POSCashBalance;
import com.gridgain.hcdemo.model.PreviousApplication;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.cache.Cache;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.binary.BinaryObject;
import org.apache.ignite.cache.CacheInterceptor;
import org.apache.ignite.cache.affinity.AffinityKey;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.SqlQuery;
import org.apache.ignite.lang.IgniteBiTuple;
import org.apache.ignite.lang.IgniteRunnable;
import org.apache.ignite.ml.IgniteModel;
import org.apache.ignite.ml.inference.builder.SingleModelBuilder;
import org.apache.ignite.ml.inference.builder.SyncModelBuilder;
import org.apache.ignite.ml.inference.parser.ModelParser;
import org.apache.ignite.ml.inference.reader.InMemoryModelReader;
import org.apache.ignite.ml.math.primitives.vector.NamedVector;
import org.apache.ignite.ml.math.primitives.vector.VectorUtils;
import org.apache.ignite.ml.math.primitives.vector.impl.DelegatingNamedVector;
import org.apache.ignite.ml.xgboost.parser.XGModelParser;
import sun.misc.IOUtils;

public class ApplicationHandler implements IgniteRunnable {

    private static final XGModelParser parser = new XGModelParser();

    private static final SyncModelBuilder modelBuilder = new SingleModelBuilder();

    private final Application application;

    private transient IgniteCache<Long, Application> applicationCache;

    private transient IgniteCache<AffinityKey<Long>, Bureau> bureauCache;

    private transient IgniteCache<AffinityKey<Long>, BureauBalance> bureauBalanceCache;

    private transient IgniteCache<AffinityKey<Long>, CreditCardBalance> creditCardBalanceCache;

    private transient IgniteCache<AffinityKey<Long>, InstallmentPayment> installmentPaymentCache;

    private transient IgniteCache<AffinityKey<Long>, POSCashBalance> posCashBalanceCache;

    private transient IgniteCache<AffinityKey<Long>, PreviousApplication> previousApplicationCache;

    private transient IgniteModel<NamedVector, Double> model;

    private transient Map<String, String> fieldMapping;

    public ApplicationHandler(Application application) {
        this.application = application;
    }

    @Override public void run() {
        long start = System.nanoTime();

        Ignite ignite = Ignition.localIgnite();

        Long skIdCurr = application.getId();

        try {
            initialize(ignite);

            List<Bureau> bureaus = getBureaus(skIdCurr);
            List<BureauBalance> bureauBalances = getBureauBalances(skIdCurr);
            List<CreditCardBalance> creditCardBalances = getCreditCardBalances(skIdCurr);
            List<InstallmentPayment> installmentPayments = getInstallmentPayments(skIdCurr);
            List<POSCashBalance> posCashBalances = getPOSCashBalances(skIdCurr);
            List<PreviousApplication> previousApplications = getPreviousApplications(skIdCurr);

            Long target = inference(
                application,
                bureaus,
                bureauBalances,
                creditCardBalances,
                installmentPayments,
                posCashBalances,
                previousApplications
            );

            application.setTarget(target);

            applicationCache.put(application.key(), application);
        }
        catch (IOException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        long end = System.nanoTime();

//        System.out.println("Time: " + (end - start) / 1_000_000.0 + "ms");
    }

    private Map<String, String> fieldMapping() {
        Map<String, String> map = new HashMap<>();

        int idx = 0;
        try (InputStream is = ApplicationHandler.class.getClassLoader().getResourceAsStream("mapping.csv")) {
            Scanner scanner = new Scanner(is);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                map.put(line, "f" + idx);
                idx++;
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        return map;
    }

    private Long inference(Application application,
        List<Bureau> bureaus,
        List<BureauBalance> bureauBalances,
        List<CreditCardBalance> creditCardBalances,
        List<InstallmentPayment> installmentPayments,
        List<POSCashBalance> posCashBalances,
        List<PreviousApplication> previousApplications) throws IllegalAccessException {

        Map<String, Double> values = new HashMap<>();

        for (Field field : Application.class.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(application);

            JsonProperty jsonProperty = field.getAnnotation(JsonProperty.class);
            if (jsonProperty != null && value instanceof Number && fieldMapping.containsKey(jsonProperty.value())) {
                values.put(fieldMapping.get(jsonProperty.value()), ((Number)value).doubleValue());
            }
        }

        NamedVector vector = VectorUtils.of(values);

        double prediction = model.predict(vector);

        System.out.println("Data: " + namedVectorToString(vector) + ", target: " + application.getTarget() + ", prediction: " + prediction);

        return prediction > 0.5 ? 1L : 0;
    }

    private void initialize(Ignite ignite) throws IOException {
        applicationCache = ignite.cache("Application");
        bureauCache = ignite.cache("Bureau");
        bureauBalanceCache = ignite.cache("BureauBalance");
        creditCardBalanceCache = ignite.cache("CreditCardBalance");
        installmentPaymentCache = ignite.cache("InstallmentPayment");
        posCashBalanceCache = ignite.cache("POSCashBalance");
        previousApplicationCache = ignite.cache("PreviousApplication");

        if (!ignite.cluster().nodeLocalMap().containsKey("MODEL")) {
            ignite.cluster().nodeLocalMap().put("MODEL", modelBuilder.build(new InMemoryModelReader(readResource("model.txt")), parser));
        }

        model = (IgniteModel<NamedVector, Double>)ignite.cluster().nodeLocalMap().get("MODEL");

        fieldMapping = fieldMapping();
    }

    private String namedVectorToString(NamedVector vector) {
        StringBuilder res = new StringBuilder();

        res.append("{");
        for (String key : vector.getKeys()) {
            res.append(key + ":" + vector.get(key) + ", ");
        }
        if (res.length() > 1)
            res.delete(res.length() - 2, res.length());
        res.append("}");

        return res.toString();
    }

    private byte[] readResource(String resource) throws IOException {
        try (InputStream is = ApplicationHandler.class.getClassLoader().getResourceAsStream(resource)) {
            return IOUtils.readFully(is, -1, true);
        }
    }

    private List<Bureau> getBureaus(Long skIdCurr) {
        List<Bureau> result = new ArrayList<>();

        String query = "from Bureau where skIdCurr = ?";
        try (QueryCursor<Cache.Entry<AffinityKey<Long>, Bureau>> cursor = bureauCache.query(
            new SqlQuery<AffinityKey<Long>, Bureau>(Bureau.class, query).setArgs(skIdCurr)
        )) {
            for (Cache.Entry<AffinityKey<Long>, Bureau> entry : cursor) {
                result.add(entry.getValue());
            }
        }

        return result;
    }

    private List<BureauBalance> getBureauBalances(Long skIdCurr) {
        List<BureauBalance> result = new ArrayList<>();

        String query = "from BureauBalance where skIdCurr = ?";
        try (QueryCursor<Cache.Entry<AffinityKey<Long>, BureauBalance>> cursor = bureauBalanceCache.query(
            new SqlQuery<AffinityKey<Long>, BureauBalance>(BureauBalance.class, query).setArgs(skIdCurr)
        )) {
            for (Cache.Entry<AffinityKey<Long>, BureauBalance> entry : cursor) {
                result.add(entry.getValue());
            }
        }

        return result;
    }

    private List<CreditCardBalance> getCreditCardBalances(Long skIdCurr) {
        List<CreditCardBalance> result = new ArrayList<>();

        String query = "from CreditCardBalance where skIdCurr = ?";
        try (QueryCursor<Cache.Entry<AffinityKey<Long>, CreditCardBalance>> cursor = creditCardBalanceCache.query(
            new SqlQuery<AffinityKey<Long>, CreditCardBalance>(CreditCardBalance.class, query).setArgs(skIdCurr)
        )) {
            for (Cache.Entry<AffinityKey<Long>, CreditCardBalance> entry : cursor) {
                result.add(entry.getValue());
            }
        }

        return result;
    }

    private List<InstallmentPayment> getInstallmentPayments(Long skIdCurr) {
        List<InstallmentPayment> result = new ArrayList<>();

        String query = "from InstallmentPayment where skIdCurr = ?";
        try (QueryCursor<Cache.Entry<AffinityKey<Long>, InstallmentPayment>> cursor = installmentPaymentCache.query(
            new SqlQuery<AffinityKey<Long>, InstallmentPayment>(InstallmentPayment.class, query).setArgs(skIdCurr)
        )) {
            for (Cache.Entry<AffinityKey<Long>, InstallmentPayment> entry : cursor) {
                result.add(entry.getValue());
            }
        }

        return result;
    }

    private List<POSCashBalance> getPOSCashBalances(Long skIdCurr) {
        List<POSCashBalance> result = new ArrayList<>();

        String query = "from POSCashBalance where skIdCurr = ?";
        try (QueryCursor<Cache.Entry<AffinityKey<Long>, POSCashBalance>> cursor = posCashBalanceCache.query(
            new SqlQuery<AffinityKey<Long>, POSCashBalance>(POSCashBalance.class, query).setArgs(skIdCurr)
        )) {
            for (Cache.Entry<AffinityKey<Long>, POSCashBalance> entry : cursor) {
                result.add(entry.getValue());
            }
        }

        return result;
    }

    private List<PreviousApplication> getPreviousApplications(Long skIdCurr) {
        List<PreviousApplication> result = new ArrayList<>();

        String query = "from PreviousApplication where skIdCurr = ?";
        try (QueryCursor<Cache.Entry<AffinityKey<Long>, PreviousApplication>> cursor = previousApplicationCache.query(
            new SqlQuery<AffinityKey<Long>, PreviousApplication>(PreviousApplication.class, query).setArgs(skIdCurr)
        )) {
            for (Cache.Entry<AffinityKey<Long>, PreviousApplication> entry : cursor) {
                result.add(entry.getValue());
            }
        }

        return result;
    }
}
