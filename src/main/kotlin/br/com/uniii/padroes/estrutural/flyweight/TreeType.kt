package br.com.uniii.padroes.estrutural.flyweight

import java.awt.Color
import java.awt.Graphics


class TreeType(val name: String, val color: Color, val otherTreeData: String) {
    fun draw(g: Graphics, x: Int, y: Int) {
        g.color = Color.BLACK
        g.fillRect(x - 1, y, 3, 5)
        g.color = color
        g.fillOval(x - 5, y - 10, 10, 10)
    }
}