package org.jid.pruebas.kotlinspringbootmultiplemongodbs.config

import com.mongodb.MongoClient
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.SimpleMongoDbFactory
import org.springframework.boot.autoconfigure.mongo.MongoProperties
import org.springframework.data.mongodb.MongoDbFactory
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@Configuration
@EnableConfigurationProperties(MultipleMongoProperties::class)
class MultipleMongoConfig(private val props: MultipleMongoProperties) {

    @Primary
    @Bean("db1MongoTemplate")
    fun db1Template(): MongoTemplate {
        return MongoTemplate(db1Factory(props.db1()))
    }

    @Bean("db2MongoTemplate")
    fun db2Template(): MongoTemplate {
        return MongoTemplate(db2Factory(props.db2()))
    }

    @Bean
    @Primary
    fun db1Factory(mongo: MongoProperties): MongoDbFactory {
        return SimpleMongoDbFactory(MongoClient(mongo.host, mongo.port),
                mongo.database)
    }

    @Bean
    fun db2Factory(mongo: MongoProperties): MongoDbFactory {
        return SimpleMongoDbFactory(MongoClient(mongo.host, mongo.port),
                mongo.database)
    }
}


@Configuration
@EnableMongoRepositories(basePackages = ["org.jid.pruebas.kotlinspringbootmultiplemongodbs.db1"],
        mongoTemplateRef = "db1MongoTemplate")
class Db1MongoConfig


@Configuration
@EnableMongoRepositories(basePackages = ["org.jid.pruebas.kotlinspringbootmultiplemongodbs.db2", "org.jid.pruebas.kotlinspringbootmultiplemongodbs.db1.repotoadifferentdb"],
        mongoTemplateRef = "db2MongoTemplate")
class Db2MongoConfig

