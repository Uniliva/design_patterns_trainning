package br.com.uniii.padroes.estrutural.adapter.quadrado

class PinoQuadrado(val largura: Double) {
    fun getQuadrado(): Double {
        return Math.pow(largura, 2.0)
    }
}