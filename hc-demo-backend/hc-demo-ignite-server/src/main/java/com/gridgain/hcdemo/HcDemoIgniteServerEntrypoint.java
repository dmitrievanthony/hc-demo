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

import com.gridgain.hcdemo.model.Bureau;
import com.gridgain.hcdemo.model.BureauBalance;
import com.gridgain.hcdemo.model.CreditCardBalance;
import com.gridgain.hcdemo.model.InstallmentPayment;
import com.gridgain.hcdemo.model.POSCashBalance;
import com.gridgain.hcdemo.model.PreviousApplication;
import com.gridgain.hcdemo.preprocessor.BureauBalancePreprocessor;
import com.gridgain.hcdemo.preprocessor.BureauPreprocessor;
import com.gridgain.hcdemo.preprocessor.CreditCardBalancePreprocessor;
import com.gridgain.hcdemo.preprocessor.InstallmentPaymentPreprocessor;
import com.gridgain.hcdemo.preprocessor.POSCashBalancePreprocessor;
import com.gridgain.hcdemo.preprocessor.PreviousApplicationPreprocessor;
import java.io.IOException;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteQueue;
import org.apache.ignite.cache.affinity.AffinityKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class HcDemoIgniteServerEntrypoint {

    private static final Logger log = LoggerFactory.getLogger(HcDemoIgniteServerEntrypoint.class);

    @Autowired
    private Ignite ignite;

    @Autowired
    private DataLoader dataLoader;

    @Autowired
    private BureauBalancePreprocessor bureauBalancePreprocessor;

    @Autowired
    private BureauPreprocessor bureauPreprocessor;

    @Autowired
    private CreditCardBalancePreprocessor creditCardBalancePreprocessor;

    @Autowired
    private InstallmentPaymentPreprocessor installmentPaymentPreprocessor;

    @Autowired
    private POSCashBalancePreprocessor posCashBalancePreprocessor;

    @Autowired
    private PreviousApplicationPreprocessor previousApplicationPreprocessor;

    @Autowired
    private IgniteCache<AffinityKey<Long>, Bureau> bureauCache;

    @Autowired
    private IgniteCache<AffinityKey<Long>, BureauBalance> bureauBalanceCache;

    @Autowired
    private IgniteCache<AffinityKey<Long>, CreditCardBalance> creditCardBalanceCache;

    @Autowired
    private IgniteCache<AffinityKey<Long>, InstallmentPayment> installmentPaymentCache;

    @Autowired
    private IgniteCache<AffinityKey<Long>, POSCashBalance> posCashBalanceCache;

    @Autowired
    private IgniteCache<AffinityKey<Long>, PreviousApplication> previousApplicationCache;

    private IgniteQueue<String> messageQueue;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) throws IOException {
        messageQueue = MessageQueue.get(ignite);

        dataLoader.loadCSV(
            new String[] {
                "data/bureau00.csv.zip",
                "data/bureau01.csv.zip"
            },
            Bureau.class,
            bureauPreprocessor,
            bureauCache
        );

        dataLoader.loadCSV(
            new String[] {
                "data/bureau_balance00.csv.zip",
                "data/bureau_balance01.csv.zip",
                "data/bureau_balance02.csv.zip",
                "data/bureau_balance03.csv.zip"
            },
            BureauBalance.class,
            bureauBalancePreprocessor,
            bureauBalanceCache
        );

        dataLoader.loadCSV(
            new String[] {
                "data/credit_card_balance00.csv.zip",
                "data/credit_card_balance01.csv.zip",
                "data/credit_card_balance02.csv.zip",
                "data/credit_card_balance03.csv.zip"
            },
            CreditCardBalance.class,
            creditCardBalancePreprocessor,
            creditCardBalanceCache
        );

        dataLoader.loadCSV(
            new String[] {
                "data/installments_payments00.csv.zip",
                "data/installments_payments00.csv.zip",
                "data/installments_payments00.csv.zip",
                "data/installments_payments00.csv.zip",
                "data/installments_payments00.csv.zip"
            },
            InstallmentPayment.class,
            installmentPaymentPreprocessor,
            installmentPaymentCache
        );

        dataLoader.loadCSV(
            new String[] {
                "data/POS_CASH_balance00.csv.zip",
                "data/POS_CASH_balance01.csv.zip",
                "data/POS_CASH_balance02.csv.zip",
                "data/POS_CASH_balance03.csv.zip"
            },
            POSCashBalance.class,
            posCashBalancePreprocessor,
            posCashBalanceCache
        );

        dataLoader.loadCSV(
            new String[] {
                "data/previous_application00.csv.zip",
                "data/previous_application01.csv.zip",
                "data/previous_application02.csv.zip"
            },
            PreviousApplication.class,
            previousApplicationPreprocessor,
            previousApplicationCache
        );

        messageQueue.put(MessageQueue.START_MSG);
    }
}
