package org.jid.pruebas.kotlinspringbootmultiplemongodbs.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.mongo.MongoProperties
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties
class MultipleMongoProperties {

    @Value("\${mongodb.db1.host}")
    private lateinit var host: String

    @Value("\${mongodb.db1.port}")
    private lateinit var port: Integer

    @Value("\${mongodb.db1.database}")
    private lateinit var database: String

    @Value("\${mongodb.db2.host}")
    private lateinit var host2: String

    @Value("\${mongodb.db2.port}")
    private lateinit var port2: Integer

    @Value("\${mongodb.db2.database}")
    private lateinit var database2: String

    fun db1(): MongoProperties = createMongoProperties(host, port.toInt(), database)

    fun db2(): MongoProperties = createMongoProperties(host2, port2.toInt(), database2)

    private fun createMongoProperties(host: String, port: Int, database: String): MongoProperties {
        val props = MongoProperties()

        props.host = host
        props.port = port
        props.database = database

        return props
    }
}



