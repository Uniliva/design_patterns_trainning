package br.com.uniii.padroes.comportamental.templateMethod

abstract class House {

    // Método Template que define o processo geral de construção
    fun buildHouse() {
        buildFoundation()
        buildStructure()
        buildRoof()
        installDoors()
        installWindows()
        paintHouse()
        furnishHouse()
        println("House construction completed.\n")
    }

    // Passos comuns
    private fun buildFoundation() {
        println("Building foundation with concrete, iron rods, and sand.")
    }

    // Passos que podem variar, e devem ser implementados pelas subclasses
    protected abstract fun buildStructure()
    protected abstract fun buildRoof()

    // Passos padrão, mas podem ser sobrescritos pelas subclasses, se necessário
    open fun installDoors() {
        println("Installing wooden doors.")
    }

    open fun installWindows() {
        println("Installing glass windows.")
    }

    open fun paintHouse() {
        println("Painting the house with default color.")
    }

    open fun furnishHouse() {
        println("Furnishing the house with standard furniture.")
    }
}


class WoodenHouse : House() {
    override fun buildStructure() {
        println("Building wooden structure.")
    }

    override fun buildRoof() {
        println("Building wooden roof.")
    }

    // Sobrescrevendo o método de pintura
    override fun paintHouse() {
        println("Painting the wooden house with natural wood color.")
    }
}


class ConcreteHouse : House() {
    override fun buildStructure() {
        println("Building concrete structure.")
    }

    override fun buildRoof() {
        println("Building concrete roof.")
    }

    // Sobrescrevendo o método de instalação de portas e janelas
    override fun installDoors() {
        println("Installing steel doors.")
    }

    override fun installWindows() {
        println("Installing tempered glass windows.")
    }

    // Sobrescrevendo o método de mobília
    override fun furnishHouse() {
        println("Furnishing the house with modern furniture.")
    }
}


fun main() {
    println("Building a Wooden House:")
    val woodenHouse = WoodenHouse()
    woodenHouse.buildHouse()

    println("Building a Concrete House:")
    val concreteHouse = ConcreteHouse()
    concreteHouse.buildHouse()
}
