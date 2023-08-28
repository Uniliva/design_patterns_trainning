package br.com.uniii.padroes.criacao.factorymethod.buttons

class HTMLButton : Button {
    override fun render() {
        println("HTMLButton - render")
    }

    override fun onClick(f: () -> Unit) {
        f()
        println("HTMLButton - onclick")
    }
}