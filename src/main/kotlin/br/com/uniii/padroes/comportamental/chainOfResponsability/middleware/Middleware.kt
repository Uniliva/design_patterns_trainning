package br.com.uniii.padroes.comportamental.chainOfResponsability.middleware

/**
 * Base middleware class.
 */
abstract class Middleware {
    private var next: Middleware? = null

    /**
     * Subclasses will implement this method with concrete checks.
     */
    abstract fun check(email: String, password: String): Boolean

    /**
     * Runs check on the next object in chain or ends traversing if we're in
     * last object in chain.
     */
    protected fun checkNext(email: String, password: String): Boolean {
        if (next == null) {
            return true
        }
        return next!!.check(email, password)
    }

    companion object {
        /**
         * Builds chains of middleware objects.
         */
        fun link(first: Middleware, vararg chain: Middleware): Middleware {
            var head = first
            for (nextInChain in chain) {
                head.next = nextInChain
                head = nextInChain
            }
            return first
        }
    }
}