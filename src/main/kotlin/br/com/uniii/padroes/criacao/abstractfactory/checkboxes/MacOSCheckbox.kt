package br.com.uniii.padroes.criacao.abstractfactory.checkboxes

class MacOSCheckbox: Checkbox {
    override fun paint() {
        println("Desenhando checkbox do MAC")
    }
}