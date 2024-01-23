package br.com.uniii.padroes.criacao.prototype.shapes

class Rectangle(x: Int, y: Int, color: String, val width: Int, val height: Int) : Shape(x, y, color) {
    constructor(rectangle: Rectangle) : this(rectangle.x, rectangle.y, rectangle.color, rectangle.width, rectangle.height)

    override fun clone(): Shape = Rectangle(this)
    override fun equals(object2: Any?): Boolean {
        if (object2 !is Rectangle || !super.equals(object2)) return false
        return object2.width === width && object2.height === height
    }

}
