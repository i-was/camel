/**
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
package org.apache.camel.osgi;

import java.util.List;

import org.apache.camel.TypeConverter;
import org.apache.camel.impl.converter.AnnotationTypeConverterLoader;
import org.apache.camel.impl.converter.DefaultTypeConverter;
import org.apache.camel.impl.converter.TypeConverterLoader;
import org.apache.camel.spring.SpringCamelContext;
import org.osgi.framework.BundleContext;
import org.springframework.context.ApplicationContext;

public class OsgiSpringCamelContext extends SpringCamelContext {
    
    public OsgiSpringCamelContext(ApplicationContext applicationContext, BundleContext bundleContext) {
        super(applicationContext);
        OsgiCamelContextHelper.osgiUpdate(this, bundleContext);
    }
    
    @Override    
    protected TypeConverter createTypeConverter() {
        return OsgiCamelContextHelper.createTypeConverter(this);
    }

}
