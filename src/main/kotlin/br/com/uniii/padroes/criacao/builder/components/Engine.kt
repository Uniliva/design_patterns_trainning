package br.com.uniii.padroes.criacao.builder.components

class Engine(
    private var volume: Double = 0.0,
    private var mileage: Double = 0.0,
    private var started: Boolean = false,
) {
    fun Engine(volume: Double, mileage: Double) {
        this.volume = volume
        this.mileage = mileage
    }

    fun on() {
        started = true
    }

    fun off() {
        started = false
    }

    fun isStarted(): Boolean {
        return started
    }

    fun go(mileage: Double) {
        if (started) {
            this.mileage += mileage
        } else {
            System.err.println("Cannot go(), you must start engine first!")
        }
    }

    fun getVolume(): Double {
        return volume
    }

    fun getMileage(): Double {
        return mileage
    }
}