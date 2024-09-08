package br.com.uniii.padroes.estrutural.adapter.adapador

import br.com.uniii.padroes.estrutural.adapter.quadrado.PinoQuadrado
import br.com.uniii.padroes.estrutural.adapter.rendondo.PinoRedondo
import kotlin.math.pow
import kotlin.math.sqrt

class PinoQuadradoAdapter(val pinoQuadrado: PinoQuadrado) :
    PinoRedondo((sqrt((pinoQuadrado.getQuadrado() / 2).pow(2.0) * 2)))