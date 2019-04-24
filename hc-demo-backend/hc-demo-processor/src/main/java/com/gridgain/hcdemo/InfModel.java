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

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.apache.ignite.Ignite;
import org.apache.ignite.ml.IgniteModel;
import org.apache.ignite.ml.inference.builder.SingleModelBuilder;
import org.apache.ignite.ml.inference.builder.SyncModelBuilder;
import org.apache.ignite.ml.inference.reader.InMemoryModelReader;
import org.apache.ignite.ml.math.primitives.vector.NamedVector;
import org.apache.ignite.ml.math.primitives.vector.VectorUtils;
import org.apache.ignite.ml.xgboost.parser.XGModelParser;
import sun.misc.IOUtils;

public class InfModel {

    private static final XGModelParser parser = new XGModelParser();

    private static final SyncModelBuilder modelBuilder = new SingleModelBuilder();

    private static final String modelKeyFormat = "MODEL[%s]";

    private final Ignite ignite;

    private final String resource;

    public InfModel(Ignite ignite, String resource) {
        this.ignite = ignite;
        this.resource = resource;
    }

    public double predict(Map<String, Double> vector) {
        return getModel().predict(VectorUtils.of(vector));
    }

    private synchronized IgniteModel<NamedVector, Double> getModel() {
        String modelKey = String.format(modelKeyFormat, resource);

        if (!ignite.cluster().nodeLocalMap().containsKey(modelKey)) {
            IgniteModel<NamedVector, Double> model = modelBuilder.build(new InMemoryModelReader(readResource(resource)), parser);
            ignite.cluster().nodeLocalMap().put(modelKey, model);
        }

        return (IgniteModel<NamedVector, Double>)ignite.cluster().nodeLocalMap().get(modelKey);
    }

    private byte[] readResource(String resource) {
        try (InputStream is = ApplicationHandler.class.getClassLoader().getResourceAsStream(resource)) {
            return IOUtils.readFully(is, -1, true);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
