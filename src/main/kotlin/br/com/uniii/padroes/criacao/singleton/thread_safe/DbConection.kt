package br.com.uniii.padroes.criacao.singleton.thread_safe

class DbConection private constructor() {

    companion object {
       // Outra forma
        /**
         * The @Volatile annotation is needed to ensure that the instance property is updated atomically.
         * This prevents other threads from creating more instances and breaking the singleton pattern.
         * We need the synchronized keyword in the static getInstance method to prevent accessing the method from multiple threads simultaneously.
         */
        @Volatile
        private var instance2: DbConection? = null

        fun getInstance() =
            instance2 ?: synchronized(this) {
                instance2 ?: DbConection().also { instance2 = it }
            }
    }


    fun query(){
        println("Executando query 1: ${this.hashCode()}")
    }

}