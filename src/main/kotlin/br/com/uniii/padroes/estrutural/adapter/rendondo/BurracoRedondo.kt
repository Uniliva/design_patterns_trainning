package br.com.uniii.padroes.estrutural.adapter.rendondo

class BurracoRedondo(val raio: Double){
    fun cabe(pino: PinoRedondo): Boolean {
        return raio >= pino.raio

    }
}