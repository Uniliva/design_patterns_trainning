package br.com.uniii.padroes.criacao.builder.builders

import br.com.uniii.padroes.criacao.builder.cars.CarType
import br.com.uniii.padroes.criacao.builder.cars.Manual
import br.com.uniii.padroes.criacao.builder.components.Engine
import br.com.uniii.padroes.criacao.builder.components.GPSNavigator
import br.com.uniii.padroes.criacao.builder.components.Transmission
import br.com.uniii.padroes.criacao.builder.components.TripComputer


class CarManualBuilder : Builder {
    private var type: CarType? = null
    private var seats = 0
    private var engine: Engine? = null
    private var transmission: Transmission? = null
    private var tripComputer: TripComputer? = null
    private var gpsNavigator: GPSNavigator? = null

    override fun setCarType(type: CarType?) {
        this.type = type
    }

    override fun setSeats(seats: Int) {
        this.seats = seats
    }

    override fun setEngine(engine: Engine?) {
        this.engine = engine
    }

    override fun setTransmission(transmission: Transmission?) {
        this.transmission = transmission
    }

    override fun setTripComputer(tripComputer: TripComputer?) {
        this.tripComputer = tripComputer
    }

    override fun setGPSNavigator(gpsNavigator: GPSNavigator?) {
        this.gpsNavigator = gpsNavigator
    }

    fun getResult(): Manual? {
        return Manual(type, seats, engine, transmission, tripComputer, gpsNavigator)
    }
}