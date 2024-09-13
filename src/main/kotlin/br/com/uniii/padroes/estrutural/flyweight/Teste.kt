package br.com.uniii.padroes.estrutural.flyweight

import java.awt.Color
import kotlin.math.floor


object Demo {
    var CANVAS_SIZE: Int = 500
    var TREES_TO_DRAW: Int = 1000000
    var TREE_TYPES: Int = 2

    @JvmStatic
    fun main(args: Array<String>) {
        val forest = Forest()
        var i = 0
        while (i < floor((TREES_TO_DRAW / TREE_TYPES).toDouble())) {
            forest.plantTree(
                random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
                "Summer Oak", Color.GREEN, "Oak texture stub"
            )
            forest.plantTree(
                random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
                "Autumn Oak", Color.ORANGE, "Autumn Oak texture stub"
            )
            i++
        }
        forest.setSize(CANVAS_SIZE, CANVAS_SIZE)
        forest.isVisible = true

        println(TREES_TO_DRAW.toString() + " trees drawn")
        println("---------------------")
        println("Memory usage:")
        println("Tree size (8 bytes) * " + TREES_TO_DRAW)
        println("+ TreeTypes size (~30 bytes) * " + TREE_TYPES + "")
        println("---------------------")
        println(
            "Total: " + ((TREES_TO_DRAW * 8 + TREE_TYPES * 30) / 1024 / 1024) +
                    "MB (instead of " + ((TREES_TO_DRAW * 38) / 1024 / 1024) + "MB)"
        )
    }

    private fun random(min: Int, max: Int): Int {
        return min + (Math.random() * ((max - min) + 1)).toInt()
    }
}