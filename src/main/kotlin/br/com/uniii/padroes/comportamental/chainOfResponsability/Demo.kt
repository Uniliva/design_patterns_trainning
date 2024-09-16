package br.com.uniii.padroes.comportamental.chainOfResponsability

import br.com.uniii.padroes.comportamental.chainOfResponsability.middleware.Middleware
import br.com.uniii.padroes.comportamental.chainOfResponsability.middleware.RoleCheckMiddleware
import br.com.uniii.padroes.comportamental.chainOfResponsability.middleware.ThrottlingMiddleware
import br.com.uniii.padroes.comportamental.chainOfResponsability.middleware.UserExistsMiddleware
import br.com.uniii.padroes.comportamental.chainOfResponsability.server.Server
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader


/**
 * Demo class. Everything comes together here.
 */
object Demo {
    private val reader = BufferedReader(InputStreamReader(System.`in`))
    private lateinit var server: Server

    private fun init() {
        server = Server()
        server.register("admin@example.com", "admin_pass")
        server.register("user@example.com", "user_pass")

        // All checks are linked. Client can build various chains using the same
        // components.
        val middleware = Middleware.link(
            ThrottlingMiddleware(2),
            UserExistsMiddleware(server),
            RoleCheckMiddleware()
        )

        // Server gets a chain from client code.
        server.setMiddleware(middleware)
    }

    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        init()

        var success: Boolean
        do {
            print("Enter email: ")
            val email = reader.readLine()
            print("Input password: ")
            val password = reader.readLine()
            success = server.logIn(email, password)
        } while (!success)
    }
}