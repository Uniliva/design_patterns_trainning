package br.com.uniii.padroes.estrutural.composite.outrosExemplos

// Componente abstrato
abstract class MenuComponent(val nome: String) {
    abstract fun exibir()
}

// Folha: Um item de menu individual
class ItemMenu(nome: String) : MenuComponent(nome) {
    override fun exibir() {
        println("Item de Menu: $nome")
    }
}

// Composto: Um menu que pode conter outros itens de menu ou submenus
class Menu(nome: String) : MenuComponent(nome) {
    private val componentes = mutableListOf<MenuComponent>()

    fun adicionar(componente: MenuComponent) {
        componentes.add(componente)
    }

    fun remover(componente: MenuComponent) {
        componentes.remove(componente)
    }

    override fun exibir() {
        println("Menu: $nome")
        for (componente in componentes) {
            componente.exibir()
        }
    }
}

fun main() {
    // Criando itens de menu individuais
    val item1 = ItemMenu("Início")
    val item2 = ItemMenu("Contato")
    val item3 = ItemMenu("Sobre")

    // Criando menus
    val menuPrincipal = Menu("Menu Principal")
    val submenu = Menu("Submenu")

    // Adicionando itens e submenus ao menu principal
    menuPrincipal.adicionar(item1)
    menuPrincipal.adicionar(submenu)
    submenu.adicionar(item2)
    submenu.adicionar(item3)

    // Exibindo todo o menu
    menuPrincipal.exibir()
}
