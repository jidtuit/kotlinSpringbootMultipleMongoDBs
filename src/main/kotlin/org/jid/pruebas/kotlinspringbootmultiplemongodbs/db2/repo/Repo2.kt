package org.jid.pruebas.kotlinspringbootmultiplemongodbs.db2.repo

import org.jid.pruebas.kotlinspringbootmultiplemongodbs.db2.model.Metric2
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface Repo2: MongoRepository<Metric2, String>