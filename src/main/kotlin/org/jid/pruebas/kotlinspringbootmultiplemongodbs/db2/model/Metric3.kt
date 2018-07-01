package org.jid.pruebas.kotlinspringbootmultiplemongodbs.db2.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Metric3(@Id val id: String, val name: String, val value: Double = 0.0)