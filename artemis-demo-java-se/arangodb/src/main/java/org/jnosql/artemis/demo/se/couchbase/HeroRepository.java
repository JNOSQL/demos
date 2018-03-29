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
package org.jnosql.artemis.demo.se.couchbase;

import org.jnosql.artemis.arangodb.document.AQL;
import org.jnosql.artemis.arangodb.document.ArangoDBRepository;
import org.jnosql.artemis.arangodb.document.Param;

import java.util.List;
import java.util.stream.Stream;

public interface HeroRepository extends ArangoDBRepository<Hero, String> {

    List<Hero> findByName(String name);

    Stream<Hero> findByAgeGreaterThan(Integer age);

    Stream<Hero> findByAgeLessThan(Integer age);

    void deleteByName(String name);

    @AQL("select * from heroes where realName= @status")
    List<Hero> find(@Param("realName") String realName);

}