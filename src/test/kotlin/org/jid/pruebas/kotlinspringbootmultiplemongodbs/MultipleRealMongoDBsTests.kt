package org.jid.pruebas.kotlinspringbootmultiplemongodbs

import org.jid.pruebas.kotlinspringbootmultiplemongodbs.db1.model.Metric1
import org.jid.pruebas.kotlinspringbootmultiplemongodbs.db1.model.Metric4
import org.jid.pruebas.kotlinspringbootmultiplemongodbs.db1.repotoadifferentdb.Repo4
import org.jid.pruebas.kotlinspringbootmultiplemongodbs.db1.repo.Repo1
import org.jid.pruebas.kotlinspringbootmultiplemongodbs.db2.anotherRepo.Repo3
import org.jid.pruebas.kotlinspringbootmultiplemongodbs.db2.model.Metric2
import org.jid.pruebas.kotlinspringbootmultiplemongodbs.db2.model.Metric3
import org.jid.pruebas.kotlinspringbootmultiplemongodbs.db2.repo.Repo2
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class MultipleRealMongoDBsTests {

	@Autowired
	lateinit var repo1: Repo1

	@Autowired
	lateinit var repo2: Repo2

	@Autowired
	lateinit var repo3: Repo3

	@Autowired
	lateinit var repo4: Repo4

	@Test
	fun mongoDb1Test() {

		val metric = Metric1("id1", "metric1", 2.8)
		repo1.save(metric)

		val findAll = repo1.findAll()

		Assert.assertEquals(1, findAll.size)
		Assert.assertEquals(metric, findAll.first())
	}


	@Test
	fun mongoDb2Test() {

		val metric = Metric2("id1", "metric2", 8.2)
		repo2.save(metric)

		val findAll = repo2.findAll()

		Assert.assertEquals(1, findAll.size)
		Assert.assertEquals(metric, findAll.first())
	}


	@Test
	fun mongoDb2_AnotherRepo_Test() {

		val metric = Metric3("id1", "metric3", 3.3)
		repo3.save(metric)

		val findAll = repo3.findAll()

		Assert.assertEquals(1, findAll.size)
		Assert.assertEquals(metric, findAll.first())
	}


	@Test
	fun mongoDb2_InDB1Namespace_Test() {

		val metric = Metric4("id1", "metric4", 4.4)
		repo4.save(metric)

		val findAll = repo4.findAll()

		Assert.assertEquals(1, findAll.size)
		Assert.assertEquals(metric, findAll.first())
	}


	@Test
	fun mongoDb1And2Test() {

		val metric1 = Metric1("id1", "metric1", 2.8)
		repo1.save(metric1)

		val metric2 = Metric2("id1", "metric2", 8.2)
		repo2.save(metric2)

		val findAll1 = repo1.findAll()
		val findAll2 = repo2.findAll()

		Assert.assertEquals(1, findAll1.size)
		Assert.assertEquals(metric1, findAll1.first())

		Assert.assertEquals(1, findAll2.size)
		Assert.assertEquals(metric2, findAll2.first())
	}

	@Before
	fun setup() {
		repo1.deleteAll()
		repo2.deleteAll()
		repo3.deleteAll()
	}

}
