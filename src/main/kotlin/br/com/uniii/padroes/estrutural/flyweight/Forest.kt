package br.com.uniii.padroes.estrutural.flyweight

import br.com.uniii.padroes.estrutural.flyweight.TreeFactory.getTreeType
import java.awt.Color
import java.awt.Graphics
import javax.swing.JFrame


class Forest : JFrame() {
    private val trees: MutableList<Tree> = ArrayList()

    fun plantTree(x: Int, y: Int, name: String, color: Color, otherTreeData: String?) {
        val type = getTreeType(name, color, otherTreeData)
        val tree = Tree(x, y, type)
        trees.add(tree)
    }

    override fun paint(graphics: Graphics) {
        for (tree in trees) {
            tree.draw(graphics)
        }
    }
}