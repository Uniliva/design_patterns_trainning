package br.com.uniii.padroes.criacao.builder.cars

import br.com.uniii.padroes.criacao.builder.components.Engine
import br.com.uniii.padroes.criacao.builder.components.GPSNavigator
import br.com.uniii.padroes.criacao.builder.components.Transmission
import br.com.uniii.padroes.criacao.builder.components.TripComputer


class Car(
    private var carType: CarType? = null,
    private var seats: Int = 0,
    private var engine: Engine? = null,
    private var transmission: Transmission? = null,
    private var tripComputer: TripComputer? = null,
    private var gpsNavigator: GPSNavigator? = null,
    private var fuel: Double = 0.0
) {


    fun Car(
        carType: CarType?, seats: Int, engine: Engine?, transmission: Transmission?,
        tripComputer: TripComputer?, gpsNavigator: GPSNavigator?
    ) {
        this.carType = carType
        this.seats = seats
        this.engine = engine
        this.transmission = transmission
        this.tripComputer = tripComputer
        if (this.tripComputer != null) {
            this.tripComputer!!.setCar(this)
        }
        this.gpsNavigator = gpsNavigator
    }

    fun getCarType(): CarType? {
        return carType
    }

    fun getFuel(): Double {
        return fuel
    }

    fun setFuel(fuel: Double) {
        this.fuel = fuel
    }

    fun getSeats(): Int {
        return seats
    }

    fun getEngine(): Engine? {
        return engine
    }

    fun getTransmission(): Transmission? {
        return transmission
    }

    fun getTripComputer(): TripComputer? {
        return tripComputer
    }

    fun getGpsNavigator(): GPSNavigator? {
        return gpsNavigator
    }
}