package br.com.uniii.padroes.comportamental.observer

// Interface Observer
interface Observer {
    fun update(temperature: Float, humidity: Float, pressure: Float)
}

// Classe Subject (WeatherStation)
class WeatherStation {
    private val observers = mutableListOf<Observer>()
    private var temperature: Float = 0.0f
    private var humidity: Float = 0.0f
    private var pressure: Float = 0.0f

    // Método para adicionar observadores
    fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    // Método para remover observadores
    fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    // Notifica todos os observadores sobre uma mudança de estado
    private fun notifyObservers() {
        for (observer in observers) {
            observer.update(temperature, humidity, pressure)
        }
    }

    // Método para simular uma mudança nas medições de clima
    fun setMeasurements(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        notifyObservers()  // Notifica todos os observadores quando há uma atualização
    }
}


// Display que exibe apenas a temperatura
class TemperatureDisplay : Observer {
    override fun update(temperature: Float, humidity: Float, pressure: Float) {
        println("Temperature Display: Current temperature is $temperature°C")
    }
}

// Display que exibe informações completas sobre o clima
class FullWeatherDisplay : Observer {
    override fun update(temperature: Float, humidity: Float, pressure: Float) {
        println("Full Weather Display: Temp = $temperature°C, Humidity = $humidity%, Pressure = $pressure hPa")
    }
}


fun main() {
    // Criamos uma estação meteorológica (Subject)
    val weatherStation = WeatherStation()

    // Criamos dois observadores
    val tempDisplay = TemperatureDisplay()
    val fullDisplay = FullWeatherDisplay()

    // Registramos os observadores na estação meteorológica
    weatherStation.addObserver(tempDisplay)
    weatherStation.addObserver(fullDisplay)

    // Simulando mudanças nas medições de clima
    weatherStation.setMeasurements(25.0f, 65.0f, 1013.1f)
    println()
    weatherStation.setMeasurements(27.5f, 70.0f, 1009.5f)

    // Removendo um observador (TemperatureDisplay)
    weatherStation.removeObserver(tempDisplay)
    println()

    // Apenas o FullWeatherDisplay será atualizado agora
    weatherStation.setMeasurements(30.0f, 60.0f, 1005.0f)
}
