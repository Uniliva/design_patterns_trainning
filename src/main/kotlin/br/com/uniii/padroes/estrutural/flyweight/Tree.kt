package br.com.uniii.padroes.estrutural.flyweight

import java.awt.Graphics


class Tree(val x: Int, val y: Int, type: TreeType) {
    private val type: TreeType = type

    fun draw(g: Graphics) {
        type.draw(g, x, y)
    }
}