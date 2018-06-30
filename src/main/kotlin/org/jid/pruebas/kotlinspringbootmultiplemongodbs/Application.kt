package org.jid.pruebas.kotlinspringbootmultiplemongodbs

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}

@SpringBootApplication
class Application(val myService: MyService): CommandLineRunner {

    override fun run(vararg args: String?) = myService.run()
}








