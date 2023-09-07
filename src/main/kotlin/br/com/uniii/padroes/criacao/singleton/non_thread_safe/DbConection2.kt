package br.com.uniii.padroes.criacao.singleton.non_thread_safe

object DbConection2 {
    fun query(){
        println("Executando query 2: ${this.hashCode()}")
    }

}