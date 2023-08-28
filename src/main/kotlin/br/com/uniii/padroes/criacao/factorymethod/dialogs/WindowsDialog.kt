package br.com.uniii.padroes.criacao.factorymethod.dialogs

import br.com.uniii.padroes.criacao.factorymethod.buttons.Button
import br.com.uniii.padroes.criacao.factorymethod.buttons.WindowsButton

class WindowsDialog : Dialog {
    override fun createButton(): Button {
       return WindowsButton()
    }
}