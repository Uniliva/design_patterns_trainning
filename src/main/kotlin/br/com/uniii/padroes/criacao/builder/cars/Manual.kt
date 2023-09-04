package br.com.uniii.padroes.criacao.builder.cars

import br.com.uniii.padroes.criacao.builder.components.Engine
import br.com.uniii.padroes.criacao.builder.components.GPSNavigator
import br.com.uniii.padroes.criacao.builder.components.Transmission
import br.com.uniii.padroes.criacao.builder.components.TripComputer


class Manual(
    private var carType: CarType? = null,
    private var seats: Int = 0,
    private var engine: Engine? = null,
    private var transmission: Transmission? = null,
    private var tripComputer: TripComputer? = null,
    private var gpsNavigator: GPSNavigator? = null,
){

    fun Manual(
        carType: CarType?, seats: Int, engine: Engine?, transmission: Transmission?,
        tripComputer: TripComputer?, gpsNavigator: GPSNavigator?
    ) {
        this.carType = carType
        this.seats = seats
        this.engine = engine
        this.transmission = transmission
        this.tripComputer = tripComputer
        this.gpsNavigator = gpsNavigator
    }

    fun print(): String? {
        var info = ""
        info += "Type of car: $carType\n"
        info += "Count of seats: $seats\n"
        info += """
             Engine: volume - ${engine!!.getVolume()}; mileage - ${engine?.getMileage()}
             
             """.trimIndent()
        info += "Transmission: $transmission\n"
        info += if (tripComputer != null) {
            """
     Trip Computer: Functional
     
     """.trimIndent()
        } else {
            """
     Trip Computer: N/A
     
     """.trimIndent()
        }
        info += if (gpsNavigator != null) {
            """
     GPS Navigator: Functional
     
     """.trimIndent()
        } else {
            """
     GPS Navigator: N/A
     
     """.trimIndent()
        }
        return info
    }

}