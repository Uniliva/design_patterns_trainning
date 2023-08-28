package br.com.uniii.padroes.criacao.factorymethod.buttons

class WindowsButton : Button {
    override fun render() {
       println("WindowsButton - render")
    }

    override fun onClick(f: () -> Unit) {
        f()
        println("WindowsButton - onclick")
    }
}