package br.com.uniii.padroes.criacao.singleton.thread_safe

class Demo {
}

fun main() {

    val singleton: DbConection = DbConection.getInstance()
    val anotherSingleton: DbConection = DbConection.getInstance()
    singleton.query()
    anotherSingleton.query()


    val singleton2: DbConection2 = DbConection2
    val anotherSingleton2: DbConection2 = DbConection2
    singleton2.query()
    anotherSingleton2.query()
}