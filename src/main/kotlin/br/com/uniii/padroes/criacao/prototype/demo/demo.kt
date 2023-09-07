package br.com.uniii.padroes.criacao.prototype.demo

import br.com.uniii.padroes.criacao.prototype.shapes.Circle
import br.com.uniii.padroes.criacao.prototype.shapes.Rectangle
import br.com.uniii.padroes.criacao.prototype.shapes.Shape


class demo {
}

fun main() {
    val shapes = mutableListOf<Shape>()
    val shapesCopy = mutableListOf<Shape>()

    val circle = Circle(x = 10, y = 20, radius = 15, color = "red")
    shapes.add(circle)
    shapes.add(circle.clone() as Circle)

    val rectangle = Rectangle(x = 10, y = 20, width = 10,height = 20,color = "blue")
    shapes.add(rectangle)

    cloneAndCompare(shapes, shapesCopy)


}

private fun cloneAndCompare(shapes: List<Shape>, shapesCopy: MutableList<Shape>) {
    for (shape in shapes) {
        shapesCopy.add(shape.clone())
    }
    for (i in shapes.indices) {
        if (shapes[i] !== shapesCopy[i]) {
            println("$i: Shapes are different objects (yay!)")
            if (shapes[i].equals(shapesCopy[i])) {
                println("$i: And they are identical (yay!)")
            } else {
                println("$i: But they are not identical (booo!)")
            }
        } else {
            println("$i: Shape objects are the same (booo!)")
        }
    }
}