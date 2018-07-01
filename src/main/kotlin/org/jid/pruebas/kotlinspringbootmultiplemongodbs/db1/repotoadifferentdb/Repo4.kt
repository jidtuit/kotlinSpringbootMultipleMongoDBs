package org.jid.pruebas.kotlinspringbootmultiplemongodbs.db1.repotoadifferentdb

import org.jid.pruebas.kotlinspringbootmultiplemongodbs.db1.model.Metric4
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface Repo4: MongoRepository<Metric4, String>