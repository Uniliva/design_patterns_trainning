package br.com.uniii.padroes.criacao.builder.components

import br.com.uniii.padroes.criacao.builder.cars.Car

class TripComputer {
    private var car: Car? = null

    fun setCar(car: Car?) {
        this.car = car
    }

    fun showFuelLevel() {
        System.out.println("Fuel level: " + car?.getFuel())
    }

    fun showStatus() {
        if (car?.getEngine()?.isStarted() == true) {
            println("Car is started")
        } else {
            println("Car isn't started")
        }
    }
}