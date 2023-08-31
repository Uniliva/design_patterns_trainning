package br.com.uniii.padroes.criacao.abstractfactory.buttons

class WindowsButton:Button {
    override fun paint() {
        println("Desenhando botão do Windows")
    }
}