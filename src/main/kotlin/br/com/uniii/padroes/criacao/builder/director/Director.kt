package br.com.uniii.padroes.criacao.builder.director

import br.com.uniii.padroes.criacao.builder.builders.Builder
import br.com.uniii.padroes.criacao.builder.cars.CarType
import br.com.uniii.padroes.criacao.builder.components.Engine
import br.com.uniii.padroes.criacao.builder.components.GPSNavigator
import br.com.uniii.padroes.criacao.builder.components.Transmission
import br.com.uniii.padroes.criacao.builder.components.TripComputer


class Director {
    fun constructSportsCar(builder: Builder) {
        builder.setCarType(CarType.SPORTS_CAR)
        builder.setSeats(2)
        builder.setEngine(Engine(3.0))
        builder.setTransmission(Transmission.SEMI_AUTOMATIC)
        builder.setTripComputer(TripComputer())
        builder.setGPSNavigator(GPSNavigator())
    }

    fun constructCityCar(builder: Builder) {
        builder.setCarType(CarType.CITY_CAR)
        builder.setSeats(2)
        builder.setEngine(Engine(1.2))
        builder.setTransmission(Transmission.AUTOMATIC)
        builder.setTripComputer(TripComputer())
        builder.setGPSNavigator(GPSNavigator())
    }

    fun constructSUV(builder: Builder) {
        builder.setCarType(CarType.SUV)
        builder.setSeats(4)
        builder.setEngine(Engine(2.5))
        builder.setTransmission(Transmission.MANUAL)
        builder.setGPSNavigator(GPSNavigator())
    }
}