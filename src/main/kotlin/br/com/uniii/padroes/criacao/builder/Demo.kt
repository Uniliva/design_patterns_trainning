package br.com.uniii.padroes.criacao.builder

import br.com.uniii.padroes.criacao.builder.builders.CarBuilder
import br.com.uniii.padroes.criacao.builder.builders.CarManualBuilder
import br.com.uniii.padroes.criacao.builder.director.Director

fun main(args: Array<String>) {
    val director = Director()

    val builder = CarBuilder()
    director.constructSportsCar(builder)

    val car = builder.getResult()
    println(" Car built: ${car!!.getCarType()}")

    val manualBuilder = CarManualBuilder()
    director.constructSportsCar(manualBuilder)

    val carManual = manualBuilder.getResult()
    println("Car manual built: ${carManual!!.print()}")
}