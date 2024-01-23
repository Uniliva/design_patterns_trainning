package br.com.uniii.padroes.criacao.prototype.shapes

class Circle(x: Int, y: Int, color: String, val radius: Int) : Shape(x, y, color) {
    constructor(circle: Circle) : this(circle.x, circle.y, circle.color, circle.radius)

    override fun clone(): Shape = Circle(this)


    override fun equals(object2: Any?): Boolean {
        if (object2 !is Circle || !super.equals(object2)) return false
        return object2.radius == radius
    }
}