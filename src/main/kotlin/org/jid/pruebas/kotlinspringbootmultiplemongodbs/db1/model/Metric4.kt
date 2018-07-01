package org.jid.pruebas.kotlinspringbootmultiplemongodbs.db1.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Metric4(@Id val id: String, val name: String, val value: Double = 0.0)