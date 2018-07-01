package org.jid.pruebas.kotlinspringbootmultiplemongodbs.db2.anotherRepo

import org.jid.pruebas.kotlinspringbootmultiplemongodbs.db2.model.Metric3
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface Repo3: MongoRepository<Metric3, String>