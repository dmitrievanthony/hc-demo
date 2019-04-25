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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
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

    private static AtomicReference<TestDataValidator> testDataValidator = new AtomicReference<>();

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

        // Application field processing.

        fieldExtractor.registerFieldProcessor(
            Application.class,
            new FieldEncoder<Application>(Application::getCodeGender, "CODE_GENDER")
                .withEncoding("M", 0.0)
                .withEncoding("F", 1.0)
        );

        fieldExtractor.registerFieldProcessor(
            Application.class,
            new FieldEncoder<Application>(Application::getFlagOwnCar, "FLAG_OWN_CAR")
                .withEncoding("Y", 1.0)
                .withEncoding("N", 0.0)
        );

        fieldExtractor.registerFieldProcessor(
            Application.class,
            new FieldEncoder<Application>(Application::getFlagOwnRealty, "FLAG_OWN_REALTY")
                .withEncoding("Y", 0.0)
                .withEncoding("N", 1.0)
        );

        fieldExtractor.registerFieldProcessor(Application.class, new FieldCalculator<Application>(
            "DAYS_EMPLOYED", Application::getDaysEmployed, 365243, Double.NaN));

        fieldExtractor.registerFieldProcessor(Application.class, new FieldCalculator<Application>(
            "DAYS_EMPLOYED_PERC",
            app -> app.getDaysEmployed() == null || app.getDaysBirth() == null ?
                Double.NaN :
                1.0 * app.getDaysEmployed() / app.getDaysBirth())
        );

        fieldExtractor.registerFieldProcessor(Application.class, new FieldCalculator<Application>(
            "INCOME_CREDIT_PERC",
            app -> app.getAmtIncomeTotal() == null || app.getAmtCredit() == null ?
                Double.NaN :
                1.0 * app.getAmtIncomeTotal() / app.getAmtCredit())
        );

        fieldExtractor.registerFieldProcessor(Application.class, new FieldCalculator<Application>(
            "INCOME_PER_PERSON",
            app -> app.getAmtIncomeTotal() == null || app.getCntFamMembers() == null ?
                Double.NaN :
                1.0 * app.getAmtIncomeTotal() / app.getCntFamMembers())
        );

        fieldExtractor.registerFieldProcessor(Application.class, new FieldCalculator<Application>(
            "ANNUITY_INCOME_PERC",
            app -> app.getAmtAnnuity() == null || app.getAmtIncomeTotal() == null ?
                Double.NaN :
                1.0 * app.getAmtAnnuity() / app.getAmtIncomeTotal())
        );

        fieldExtractor.registerFieldProcessor(Application.class, new FieldCalculator<Application>(
            "PAYMENT_RATE",
            app -> app.getAmtAnnuity() == null || app.getAmtCredit() == null ?
                Double.NaN :
                1.0 * app.getAmtAnnuity() / app.getAmtCredit())
        );

        // Previous application field processing.

        fieldExtractor.registerFieldProcessor(PreviousApplication.class, new FieldCalculator<PreviousApplication>(
            "DAYS_EMPLOYED", PreviousApplication::getDaysFirstDrawing, 365243, Double.NaN));

        fieldExtractor.registerFieldProcessor(PreviousApplication.class, new FieldCalculator<PreviousApplication>(
            "DAYS_FIRST_DUE", PreviousApplication::getDaysFirstDue, 365243, Double.NaN));

        fieldExtractor.registerFieldProcessor(PreviousApplication.class, new FieldCalculator<PreviousApplication>(
            "DAYS_LAST_DUE_1ST_VERSION", PreviousApplication::getDaysLastBue1stVersion, 365243, Double.NaN));

        fieldExtractor.registerFieldProcessor(PreviousApplication.class, new FieldCalculator<PreviousApplication>(
            "DAYS_LAST_DUE", PreviousApplication::getDaysLastDue, 365243, Double.NaN));

        fieldExtractor.registerFieldProcessor(PreviousApplication.class, new FieldCalculator<PreviousApplication>(
            "DAYS_TERMINATION", PreviousApplication::getDaysTermination, 365243, Double.NaN));

        fieldExtractor.registerFieldProcessor(PreviousApplication.class, new FieldCalculator<PreviousApplication>(
            "APP_CREDIT_PERC",
            app -> app.getAmtApplication() == null || app.getAmtCredit() == null ?
                Double.NaN :
                1.0 * app.getAmtApplication() / app.getAmtCredit())
        );

        // Installments payments processing.

        fieldExtractor.registerFieldProcessor(InstallmentPayment.class, new FieldCalculator<InstallmentPayment>(
            "PAYMENT_PERC",
            app -> app.getAmtPayment() == null || app.getAmtInstalment() == null ?
                Double.NaN :
                1.0 * app.getAmtPayment() / app.getAmtInstalment())
        );

        fieldExtractor.registerFieldProcessor(InstallmentPayment.class, new FieldCalculator<InstallmentPayment>(
            "PAYMENT_DIFF",
            app -> app.getAmtInstalment() == null || app.getAmtPayment() == null ?
                Double.NaN :
                1.0 * app.getAmtInstalment() - app.getAmtPayment())
        );

        fieldExtractor.registerFieldProcessor(InstallmentPayment.class, new FieldCalculator<InstallmentPayment>(
            "DPD",
            app -> app.getDaysEntryPayment() == null || app.getDaysInstalment() == null ?
                Double.NaN :
                Math.max(1.0 * app.getDaysEntryPayment() - app.getDaysInstalment(), 0))
        );

        fieldExtractor.registerFieldProcessor(InstallmentPayment.class, new FieldCalculator<InstallmentPayment>(
            "DBD",
            app -> app.getDaysInstalment() == null || app.getDaysEntryPayment() == null ?
                Double.NaN :
                Math.max(1.0 * app.getDaysInstalment() - app.getDaysEntryPayment(), 0))
        );

        aggregationFieldExtractor = new AggregationFieldExtractor(fieldExtractor);
        testDataValidator.compareAndSet(null, new TestDataValidator("first_100_rows.csv"));
    }

    private Long inference(Application application,
        List<Bureau> bureaus,
        List<BureauBalance> bureauBalances,
        List<CreditCardBalance> creditCardBalances,
        List<InstallmentPayment> installmentPayments,
        List<POSCashBalance> posCashBalances,
        List<PreviousApplication> previousApplications) {

        Map<String, Double> values = fieldExtractor.extract(application);
        values.putAll(aggregationFieldExtractor.extract("BURO", bureaus));
        values.putAll(aggregationFieldExtractor.extract("BURO", bureauBalances));
        values.putAll(aggregationFieldExtractor.extract("CC", creditCardBalances));
        values.putAll(aggregationFieldExtractor.extract("INSTAL", installmentPayments));
        values.putAll(aggregationFieldExtractor.extract("POS", posCashBalances));
        values.putAll(aggregationFieldExtractor.extract("PREV", previousApplications));

        // Validation.
        testDataValidator.get().validate(values);

        Map<String, Double> vector = fieldMapping.emptyVector();
        vector.putAll(fieldMapping.map(values));

        double prediction = model.predict(vector);

        StringBuilder bldr = new StringBuilder();
        bldr.append("Bureas: " + bureaus.size() + "\n");
        bldr.append("Burea balances: " + bureauBalances.size() + "\n");
        bldr.append("Credit card balances: " + creditCardBalances.size() + "\n");
        bldr.append("Installment payments: " + installmentPayments.size() + "\n");
        bldr.append("POS cash balances: " + posCashBalances.size() + "\n");
        bldr.append("Previous applications: " + previousApplications.size() + "\n");
        bldr.append("Data: " + Arrays.toString(values.entrySet().toArray()) + "\n");
        bldr.append("Prediction: " + prediction);

        System.out.println(bldr.toString());

        return prediction > 0.5 ? 1L : 0;
    }
}
