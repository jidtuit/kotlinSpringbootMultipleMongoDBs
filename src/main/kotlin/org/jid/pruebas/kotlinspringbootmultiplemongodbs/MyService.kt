package org.jid.pruebas.kotlinspringbootmultiplemongodbs

import org.jid.pruebas.kotlinspringbootmultiplemongodbs.db1.model.Metric1
import org.jid.pruebas.kotlinspringbootmultiplemongodbs.db1.repo.Repo1
import org.jid.pruebas.kotlinspringbootmultiplemongodbs.db2.model.Metric2
import org.jid.pruebas.kotlinspringbootmultiplemongodbs.db2.repo.Repo2
import org.springframework.stereotype.Service

interface MyService {

    fun getRepo1(): Repo1
    fun getRepo2(): Repo2
    fun run()
}


@Service
class MyServiceImpl(val rep1: Repo1, val rep2: Repo2) : MyService {
    override fun getRepo1(): Repo1 = rep1

    override fun getRepo2(): Repo2 = rep2

    override fun run() {
        val metric = Metric1("id1", "metric1", 2.8)
        rep1.save(metric)

        val metric2 = Metric2("id1", "metric2", 8.2)
        rep2.save(metric2)
    }

}
