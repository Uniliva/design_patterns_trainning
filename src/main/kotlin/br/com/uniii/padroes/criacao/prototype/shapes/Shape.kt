package br.com.uniii.padroes.criacao.prototype.shapes


abstract class Shape(
    val x: Int,
    val y: Int,
    val color: String
) {
    constructor(shape: Shape) : this(shape.x, shape.y, shape.color)

    abstract fun clone(): Shape

    override fun equals(object2: Any?): Boolean {
        if (object2 !is Shape) return false
        val shape2 = object2
        return shape2.x === x && shape2.y === y && shape2.color == color
    }
}