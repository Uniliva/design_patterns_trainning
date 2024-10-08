package br.com.uniii.padroes.comportamental.chainOfResponsability.middleware

/**
 * ConcreteHandler. Checks a user's role.
 */
class RoleCheckMiddleware : Middleware() {
    override fun check(email: String, password: String): Boolean {
        if (email == "admin@example.com") {
            println("Hello, admin!")
            return true
        }
        println("Hello, user!")
        return checkNext(email, password)
    }
}