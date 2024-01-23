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
        return object2.x == x && object2.y == y && object2.color == color
    }
}