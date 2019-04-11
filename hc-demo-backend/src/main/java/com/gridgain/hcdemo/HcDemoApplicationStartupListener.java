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
import com.gridgain.hcdemo.core.model.Application;
import com.gridgain.hcdemo.core.preprocessor.ApplicationPreprocessor;
import com.gridgain.hcdemo.core.preprocessor.BureauBalancePreprocessor;
import com.gridgain.hcdemo.core.preprocessor.BureauPreprocessor;
import com.gridgain.hcdemo.core.preprocessor.ClientPreprocessor;
import com.gridgain.hcdemo.core.preprocessor.CreditCardBalancePreprocessor;
import com.gridgain.hcdemo.core.preprocessor.InstalmentPaymentPreprocessor;
import com.gridgain.hcdemo.core.preprocessor.POSCashBalancePreprocessor;
import com.gridgain.hcdemo.core.preprocessor.Preprocessor;
import com.gridgain.hcdemo.core.preprocessor.PreviousApplicationPreprocessor;
import com.gridgain.hcdemo.core.repository.ApplicationRepository;
import com.gridgain.hcdemo.core.repository.BureauBalanceRepository;
import com.gridgain.hcdemo.core.repository.BureauRepository;
import com.gridgain.hcdemo.core.repository.ClientRepository;
import com.gridgain.hcdemo.core.repository.CreditCardBalanceRepository;
import com.gridgain.hcdemo.core.repository.InstalmentPaymentRepository;
import com.gridgain.hcdemo.core.repository.POSCashBalanceRepository;
import com.gridgain.hcdemo.core.repository.PreviousApplicationRepository;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class HcDemoApplicationStartupListener {

    private static final Logger log = LoggerFactory.getLogger(HcDemoApplicationStartupListener.class);

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private BureauBalanceRepository balanceRepository;

    @Autowired
    private BureauRepository bureauRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CreditCardBalanceRepository creditCardBalanceRepository;

    @Autowired
    private InstalmentPaymentRepository instalmentPaymentRepository;

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
    private InstalmentPaymentPreprocessor instalmentPaymentPreprocessor;

    @Autowired
    private POSCashBalancePreprocessor posCashBalancePreprocessor;

    @Autowired
    private PreviousApplicationPreprocessor previousApplicationPreprocessor;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) throws IOException {
        loadCSV("data/application.csv", Application.class, applicationRepository, applicationPreprocessor);
    }

    private <T> void loadCSV(String resource, Class<T> clazz, CrudRepository<T, ?> repository,
        Preprocessor<T> preprocessor) throws IOException {
        log.info("Start loading data [resource=" + resource + "]");

        CsvMapper mapper = new CsvMapper();

        CsvSchema schema = mapper.schemaFor(clazz).withHeader().withColumnReordering(true);

        MappingIterator<T> objects = mapper
            .readerWithSchemaFor(clazz)
            .with(schema)
            .readValues(HcDemoApplication.class.getClassLoader().getResourceAsStream(resource));

        while (objects.hasNext()) {
            T object = objects.next();
            object = preprocessor.preprocess(object);
            repository.save(object);
        }

        log.info("Data has been loaded [resource=" + resource + "]");
    }
}
