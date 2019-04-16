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

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.gridgain.hcdemo.model.Application;
import com.gridgain.hcdemo.model.Bureau;
import com.gridgain.hcdemo.model.BureauBalance;
import com.gridgain.hcdemo.model.CreditCardBalance;
import com.gridgain.hcdemo.model.InstallmentPayment;
import com.gridgain.hcdemo.model.POSCashBalance;
import com.gridgain.hcdemo.model.PreviousApplication;
import com.gridgain.hcdemo.preprocessor.ApplicationPreprocessor;
import com.gridgain.hcdemo.preprocessor.BureauBalancePreprocessor;
import com.gridgain.hcdemo.preprocessor.BureauPreprocessor;
import com.gridgain.hcdemo.preprocessor.ClientPreprocessor;
import com.gridgain.hcdemo.preprocessor.CreditCardBalancePreprocessor;
import com.gridgain.hcdemo.preprocessor.InstallmentPaymentPreprocessor;
import com.gridgain.hcdemo.preprocessor.POSCashBalancePreprocessor;
import com.gridgain.hcdemo.preprocessor.Preprocessor;
import com.gridgain.hcdemo.preprocessor.PreviousApplicationPreprocessor;
import com.gridgain.hcdemo.repository.ApplicationRepository;
import com.gridgain.hcdemo.repository.BureauBalanceRepository;
import com.gridgain.hcdemo.repository.BureauRepository;
import com.gridgain.hcdemo.repository.ClientRepository;
import com.gridgain.hcdemo.repository.CreditCardBalanceRepository;
import com.gridgain.hcdemo.repository.InstallmentPaymentRepository;
import com.gridgain.hcdemo.repository.POSCashBalanceRepository;
import com.gridgain.hcdemo.repository.PreviousApplicationRepository;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    private static final Logger log = LoggerFactory.getLogger(DataLoader.class);

    @Value("${loader.batch-size:100000}")
    private int batchSize;

    @Value("${loader.rows-to-be-loaded:-1}")
    private int rowsToBeLoaded;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private BureauBalanceRepository bureauBalanceRepository;

    @Autowired
    private BureauRepository bureauRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CreditCardBalanceRepository creditCardBalanceRepository;

    @Autowired
    private InstallmentPaymentRepository installmentPaymentRepository;

    @Autowired
    private POSCashBalanceRepository posCashBalanceRepository;

    @Autowired
    private PreviousApplicationRepository previousApplicationRepository;

    @Autowired
    private ApplicationPreprocessor applicationPreprocessor;

    @Autowired
    private BureauBalancePreprocessor bureauBalancePreprocessor;

    @Autowired
    private BureauPreprocessor bureauPreprocessor;

    @Autowired
    private ClientPreprocessor clientPreprocessor;

    @Autowired
    private CreditCardBalancePreprocessor creditCardBalancePreprocessor;

    @Autowired
    private InstallmentPaymentPreprocessor installmentPaymentPreprocessor;

    @Autowired
    private POSCashBalancePreprocessor posCashBalancePreprocessor;

    @Autowired
    private PreviousApplicationPreprocessor previousApplicationPreprocessor;

    public void loadData() throws IOException {
        loadCSV(
            new String[]{
                "data/application_train00.csv.zip",
                "data/application_train01.csv.zip"
            },
            Application.class,
            applicationRepository,
            applicationPreprocessor,
            rowsToBeLoaded
        );

        loadCSV(
            new String[]{
                "data/bureau00.csv.zip",
                "data/bureau01.csv.zip"
            },
            Bureau.class,
            bureauRepository,
            bureauPreprocessor,
            rowsToBeLoaded
        );

        loadCSV(
            new String[]{
                "data/bureau_balance00.csv.zip",
                "data/bureau_balance01.csv.zip",
                "data/bureau_balance02.csv.zip",
                "data/bureau_balance03.csv.zip"
            },
            BureauBalance.class,
            bureauBalanceRepository,
            bureauBalancePreprocessor,
            rowsToBeLoaded
        );

        loadCSV(
            new String[]{
                "data/credit_card_balance00.csv.zip",
                "data/credit_card_balance01.csv.zip",
                "data/credit_card_balance02.csv.zip",
                "data/credit_card_balance03.csv.zip"
            },
            CreditCardBalance.class,
            creditCardBalanceRepository,
            creditCardBalancePreprocessor,
            rowsToBeLoaded
        );

        loadCSV(
            new String[]{
                "data/installments_payments00.csv.zip",
                "data/installments_payments00.csv.zip",
                "data/installments_payments00.csv.zip",
                "data/installments_payments00.csv.zip",
                "data/installments_payments00.csv.zip"
            },
            InstallmentPayment.class,
            installmentPaymentRepository,
            installmentPaymentPreprocessor,
            rowsToBeLoaded
        );

        loadCSV(
            new String[]{
                "data/POS_CASH_balance00.csv.zip",
                "data/POS_CASH_balance01.csv.zip",
                "data/POS_CASH_balance02.csv.zip",
                "data/POS_CASH_balance03.csv.zip"
            },
            POSCashBalance.class,
            posCashBalanceRepository,
            posCashBalancePreprocessor,
            rowsToBeLoaded
        );

        loadCSV(
            new String[]{
                "data/previous_application00.csv.zip",
                "data/previous_application01.csv.zip",
                "data/previous_application02.csv.zip"
            },
            PreviousApplication.class,
            previousApplicationRepository,
            previousApplicationPreprocessor,
            rowsToBeLoaded
        );
    }

    private <T> void loadCSV(String[] resources, Class<T> clazz, CrudRepository<T, ?> repository,
        Preprocessor<T> preprocessor, long rows) throws IOException {
        log.info("Start loading data [resource=" + Arrays.toString(resources) + "]");

        CsvMapper mapper = new CsvMapper();

        CsvSchema schema = mapper.schemaFor(clazz).withHeader().withColumnReordering(true);

        long row = 0;
        for (String resource : resources) {
            try (InputStream is = DataLoader.class.getClassLoader().getResourceAsStream(resource);
                 ZipInputStream zis = new ZipInputStream(is)) {
                ZipEntry entry = zis.getNextEntry();

                log.info("Processing zip entry [entry=" + entry.getName() + "]");

                MappingIterator<T> objects = mapper
                    .readerWithSchemaFor(clazz)
                    .with(schema)
                    .readValues(zis);

                List<T> batch = new ArrayList<>();
                int batchNumber = 0;
                while (objects.hasNext()) {
                    if (rows != -1 && rows == row)
                        break;

                    T object = objects.next();
                    object = preprocessor.preprocess(object);
                    batch.add(object);

                    row++;

                    if (batch.size() == batchSize) {
                        repository.saveAll(batch);
                        batch.clear();

                        log.info("Data is loading [resource=" + resource + ", batch=" + batchNumber + "]");

                        batchNumber++;
                    }
                }

                if (!batch.isEmpty())
                    repository.saveAll(batch);
            }
        }

        log.info("Data has been loaded [resource=" + Arrays.toString(resources) + "]");
    }
}
