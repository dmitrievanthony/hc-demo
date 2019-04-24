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

import com.gridgain.hcdemo.model.Application;
import com.gridgain.hcdemo.model.Bureau;
import com.gridgain.hcdemo.model.BureauBalance;
import com.gridgain.hcdemo.model.CreditCardBalance;
import com.gridgain.hcdemo.model.InstallmentPayment;
import com.gridgain.hcdemo.model.POSCashBalance;
import com.gridgain.hcdemo.model.PreviousApplication;
import com.gridgain.hcdemo.test.TestDataIterator;
import com.gridgain.hcdemo.test.TestDataValidator;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.affinity.AffinityKey;
import org.apache.ignite.lang.IgniteRunnable;

import static com.gridgain.hcdemo.ReferenceDataExtractor.extract;

public class ApplicationHandler implements IgniteRunnable {

    private final Application application;

    private transient IgniteCache<Long, Application> applicationCache;

    private transient IgniteCache<AffinityKey<Long>, Bureau> bureauCache;

    private transient IgniteCache<AffinityKey<Long>, BureauBalance> bureauBalanceCache;

    private transient IgniteCache<AffinityKey<Long>, CreditCardBalance> creditCardBalanceCache;

    private transient IgniteCache<AffinityKey<Long>, InstallmentPayment> installmentPaymentCache;

    private transient IgniteCache<AffinityKey<Long>, POSCashBalance> posCashBalanceCache;

    private transient IgniteCache<AffinityKey<Long>, PreviousApplication> previousApplicationCache;

    private transient InfModel model;

    private transient FieldMapping fieldMapping;

    private transient FieldExtractor fieldExtractor;

    private transient AggregationFieldExtractor aggregationFieldExtractor;

    private transient TestDataValidator testDataValidator;

    public ApplicationHandler(Application application) {
        this.application = application;
    }

    @Override public void run() {
        long start = System.nanoTime();

        Ignite ignite = Ignition.localIgnite();
        initialize(ignite);

        Long target = inference(
            application,
            extract(bureauCache, Bureau.class, application.getId()),
            extract(bureauBalanceCache, BureauBalance.class, application.getId()),
            extract(creditCardBalanceCache, CreditCardBalance.class, application.getId()),
            extract(installmentPaymentCache, InstallmentPayment.class, application.getId()),
            extract(posCashBalanceCache, POSCashBalance.class, application.getId()),
            extract(previousApplicationCache, PreviousApplication.class, application.getId())
        );

        application.setTarget(target);

        applicationCache.put(application.key(), application);

        long end = System.nanoTime();

        System.out.println("Time: " + (end - start) / 1_000_000.0 + "ms");
    }

    private void initialize(Ignite ignite) {
        applicationCache = ignite.cache("Application");
        bureauCache = ignite.cache("Bureau");
        bureauBalanceCache = ignite.cache("BureauBalance");
        creditCardBalanceCache = ignite.cache("CreditCardBalance");
        installmentPaymentCache = ignite.cache("InstallmentPayment");
        posCashBalanceCache = ignite.cache("POSCashBalance");
        previousApplicationCache = ignite.cache("PreviousApplication");
        model = new InfModel(ignite, "model.txt");
        fieldMapping = new FieldMapping("mapping.csv");
        fieldExtractor = new FieldExtractor(fieldMapping);
        aggregationFieldExtractor = new AggregationFieldExtractor(fieldExtractor);
        testDataValidator = new TestDataValidator("first_100_rows.csv");
    }

    private Long inference(Application application,
        List<Bureau> bureaus,
        List<BureauBalance> bureauBalances,
        List<CreditCardBalance> creditCardBalances,
        List<InstallmentPayment> installmentPayments,
        List<POSCashBalance> posCashBalances,
        List<PreviousApplication> previousApplications) {

        Map<String, Double> values = fieldExtractor.extract(application);
        values.putAll(aggregationFieldExtractor.extract(bureaus));
        values.putAll(aggregationFieldExtractor.extract(bureauBalances));
        values.putAll(aggregationFieldExtractor.extract(creditCardBalances));
        values.putAll(aggregationFieldExtractor.extract(installmentPayments));
        values.putAll(aggregationFieldExtractor.extract(posCashBalances));
        values.putAll(aggregationFieldExtractor.extract(previousApplications));

        // Validation.
        testDataValidator.validate(values);

        Map<String, Double> vector = fieldMapping.emptyVector();
        vector.putAll(fieldMapping.map(values));

        double prediction = model.predict(vector);

        System.out.println("Data: " + Arrays.toString(values.entrySet().toArray()) + ", prediction: " + prediction);

        return prediction > 0.5 ? 1L : 0;
    }
}
