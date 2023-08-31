package br.com.uniii.padroes.criacao.abstractfactory.buttons

class MacOSButton: Button {
    override fun paint() {
        println("Desenhando botão do MAC")
    }
}