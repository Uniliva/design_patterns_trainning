package br.com.uniii.padroes.estrutural.brigde.devices

abstract class Device(
    var ligado: Boolean,
    var canal: Int
) {
    var volume: Int = 0
        set(volume) {
            if (volume > 100) {
                field = 100;
            } else if (volume < 0) {
                field = 0;
            } else {
                field = volume;
            }
            field = volume
        }

    fun status() {
        println("""
            Ligado: ${this.ligado}
            Volume: ${this.volume}
            Canal: ${this.canal}
        """.trimIndent()

        )
    }
}

class Radio(volume: Int = 10, ligado: Boolean = false, canal: Int = 6) : Device(ligado, canal) {
    init {
        super.volume = volume
    }
}

class TV(volume: Int = 30, ligado: Boolean = false, canal: Int = 1) : Device(ligado, canal) {
    init {
        super.volume = volume
    }
}
