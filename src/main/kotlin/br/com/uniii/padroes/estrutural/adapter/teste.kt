package br.com.uniii.padroes.estrutural.adapter

import br.com.uniii.padroes.estrutural.adapter.adapador.PinoQuadradoAdapter
import br.com.uniii.padroes.estrutural.adapter.quadrado.PinoQuadrado
import br.com.uniii.padroes.estrutural.adapter.rendondo.BurracoRedondo
import br.com.uniii.padroes.estrutural.adapter.rendondo.PinoRedondo

fun main(args: Array<String>) {

    val buracoRedondo = BurracoRedondo(5.toDouble())
    val pinoRedondo = PinoRedondo(5.toDouble())

    mostraTela(buracoRedondo, pinoRedondo)

    val pinoQuadrado = PinoQuadrado(2.toDouble())
    val pinoQuadradoGrande = PinoQuadrado(20.toDouble())

    val pinoAdaptado = PinoQuadradoAdapter(pinoQuadrado)
    val pinoGrandeAdaptado = PinoQuadradoAdapter(pinoQuadradoGrande)

    mostraTela(buracoRedondo, pinoAdaptado)
    mostraTela(buracoRedondo, pinoGrandeAdaptado)

}

private fun mostraTela(
    buracoRedondo: BurracoRedondo,
    pinoRedondo: PinoRedondo
) {
    if (buracoRedondo.cabe(pinoRedondo)) {
        println("O Buraco com raio de ${buracoRedondo.raio} cabe o pino com o raio de ${pinoRedondo.raio}")
    } else {
        println("O Buraco com raio de ${buracoRedondo.raio} nao cabe o pino com o raio de ${pinoRedondo.raio}")
    }
}