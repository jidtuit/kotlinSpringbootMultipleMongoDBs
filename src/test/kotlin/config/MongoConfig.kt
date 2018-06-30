/*package config

import com.mongodb.MongoClient
import cz.jirutka.spring.embedmongo.EmbeddedMongoBuilder
import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate

@Configuration
class MongoConfig {

    @Bean
    fun mongoTemplate(): MongoTemplate {
        val mongoFB = EmbeddedMongoFactoryBean()

        mongoFB.setBindIp("localhost")

        val mongoClient = mongoFB.`object`

        return MongoTemplate(mongoClient!!, "myDb1")
    }

}
        */