package org.jid.pruebas.kotlinspringbootmultiplemongodbs.db1.repo

import org.jid.pruebas.kotlinspringbootmultiplemongodbs.db1.model.Metric1
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface Repo1: MongoRepository<Metric1, String>