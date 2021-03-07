/*
 * Copyright (c) 2017 Otávio Santana and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Apache License v2.0 is available at http://www.opensource.org/licenses/apache2.0.php.
 *
 * You may elect to redistribute this code under either of these licenses.
 *
 * Contributors:
 *
 * Otavio Santana
 */

package org.jnosql.artemis.demo.se;


import jakarta.nosql.column.ColumnFamilyManager;
import jakarta.nosql.mapping.column.ColumnTemplate;
import org.eclipse.jnosql.communication.cassandra.column.CassandraColumnFamilyManager;
import org.eclipse.jnosql.communication.cassandra.column.CassandraColumnFamilyManagerFactory;
import org.eclipse.jnosql.communication.cassandra.column.CassandraConfiguration;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
public class CassandraProducer {


    @Inject
    @ConfigProperty(name = "column")
    private ColumnFamilyManager columnManager;


    @Produces
    public CassandraColumnFamilyManager getManagerCassandra() {
        return (CassandraColumnFamilyManager) columnManager;
    }

}
