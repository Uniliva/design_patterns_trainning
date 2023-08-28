package br.com.uniii.padroes.criacao.factorymethod.dialogs

import br.com.uniii.padroes.criacao.factorymethod.buttons.Button
import br.com.uniii.padroes.criacao.factorymethod.buttons.HTMLButton

class WebDialog: Dialog {
    override fun createButton(): Button {
        return HTMLButton()
    }
}