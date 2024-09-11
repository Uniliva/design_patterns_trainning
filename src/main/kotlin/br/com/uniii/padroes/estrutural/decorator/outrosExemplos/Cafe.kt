package br.com.uniii.padroes.estrutural.decorator.outrosExemplos

interface Cafe {
    fun preparar(): String
}

class CafeSimples : Cafe {
    override fun preparar(): String {
        return "Café simples"
    }
}

abstract class DecoradorCafe(private val cafe: Cafe) : Cafe {
    override fun preparar(): String {
        return cafe.preparar()
    }
}

class CafeComLeite(cafe: Cafe) : DecoradorCafe(cafe) {
    override fun preparar(): String {
        return "${super.preparar()} com leite"
    }
}

class CafeComAcucar(cafe: Cafe) : DecoradorCafe(cafe) {
    override fun preparar(): String {
        return "${super.preparar()} com açúcar"
    }
}

fun main() {
    val cafeSimples = CafeSimples()
    println(cafeSimples.preparar()) // Saída: Café simples

    val cafeComLeite = CafeComLeite(cafeSimples)
    println(cafeComLeite.preparar()) // Saída: Café simples com leite

    val cafeCompleto = CafeComAcucar(CafeComLeite(cafeSimples))
    println(cafeCompleto.preparar()) // Saída: Café simples com leite com açúcar
}