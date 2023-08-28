package br.com.uniii.padroes.criacao.factorymethod.dialogs

import br.com.uniii.padroes.criacao.factorymethod.buttons.Button

interface Dialog {
    abstract fun createButton(): Button
    fun render(){
        val okButton = createButton()
        okButton.onClick { println("fechando janela") }
        okButton.render()
    }
}