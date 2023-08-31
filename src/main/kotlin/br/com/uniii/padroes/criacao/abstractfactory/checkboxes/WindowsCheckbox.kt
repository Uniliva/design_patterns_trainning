package br.com.uniii.padroes.criacao.abstractfactory.checkboxes

class WindowsCheckbox: Checkbox {
    override fun paint() {
        println("Desenhando checkbox do Windows")
    }
}