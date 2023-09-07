package br.com.uniii.padroes.criacao.singleton.non_thread_safe

class DbConection private constructor() {

    companion object {
        val instance: DbConection by lazy {
            DbConection()
        }
    }


    fun query(){
        println("Executando query 1: ${this.hashCode()}")
    }

}