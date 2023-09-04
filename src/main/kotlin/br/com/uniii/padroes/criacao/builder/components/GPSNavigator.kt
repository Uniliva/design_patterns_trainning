package br.com.uniii.padroes.criacao.builder.components

class GPSNavigator {
    private var route: String? = null

    fun GPSNavigator() {
        route = "221b, Baker Street, London  to Scotland Yard, 8-10 Broadway, London"
    }

    fun GPSNavigator(manualRoute: String?) {
        route = manualRoute
    }

    fun getRoute(): String? {
        return route
    }
}