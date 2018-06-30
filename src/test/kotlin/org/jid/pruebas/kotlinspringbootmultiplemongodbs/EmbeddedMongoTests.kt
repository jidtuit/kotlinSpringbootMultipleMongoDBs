/*package org.jid.pruebas.kotlinspringbootmultiplemongodbs

import config.MongoConfig
import org.jid.pruebas.kotlinspringbootmultiplemongodbs.db1.model.Metric1
import org.jid.pruebas.kotlinspringbootmultiplemongodbs.db1.repo.Repo1
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
@Import(MongoConfig::class)
class EmbeddedMongoTests {

	@Autowired
	lateinit var repo1: Repo1

	@Test
	fun mongoTest1() {

		val metric = Metric1("id1", "metric1", 2.8)
		repo1.save(metric)

		val findAll = repo1.findAll()

		assertEquals(1, findAll.size)
		assertEquals(metric, findAll.first())
	}

}
*/