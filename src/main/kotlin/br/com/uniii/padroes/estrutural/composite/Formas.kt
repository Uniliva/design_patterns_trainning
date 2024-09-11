package br.com.uniii.padroes.estrutural.composite

import java.awt.Color
import java.awt.Graphics


abstract class Forma(val x: Int, val y: Int, val color: Color) {
    abstract fun desenhar(g: Graphics)
}

class Circulo(x: Int, y: Int, val raio: Int, color: Color) : Forma(x, y, color) {
    override fun desenhar(g: Graphics) {
        g.color = color
        g.drawOval(x, y, raio * 2, raio * 2)
    }
}

class Retangulo(x: Int, y: Int, val largura: Int, val altura: Int, color: Color) : Forma(x, y, color) {
    override fun desenhar(g: Graphics) {
        g.color = color
        g.drawRect(x, y, largura, altura)
    }
}

// Implementação de uma classe composta que contém outras formas
class FormaComposta : Forma(0, 0, Color.BLACK) {
    private val formas = mutableListOf<Forma>()

    fun adicionar(forma: Forma) {
        formas.add(forma)
    }

    fun remover(forma: Forma) {
        formas.remove(forma)
    }

    override fun desenhar(g: Graphics) {
        for (forma in formas) {
            forma.desenhar(g)
        }
    }
}