package br.com.uniii.padroes.criacao.builder.builders

import br.com.uniii.padroes.criacao.builder.cars.CarType
import br.com.uniii.padroes.criacao.builder.components.Engine
import br.com.uniii.padroes.criacao.builder.components.GPSNavigator
import br.com.uniii.padroes.criacao.builder.components.Transmission
import br.com.uniii.padroes.criacao.builder.components.TripComputer

interface Builder {
    fun setCarType(type: CarType?)
    fun setSeats(seats: Int)
    fun setEngine(engine: Engine?)
    fun setTransmission(transmission: Transmission?)
    fun setTripComputer(tripComputer: TripComputer?)
    fun setGPSNavigator(gpsNavigator: GPSNavigator?)
}