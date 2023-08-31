package br.com.uniii.padroes.criacao.abstractfactory

import br.com.uniii.padroes.criacao.abstractfactory.buttons.Button
import br.com.uniii.padroes.criacao.abstractfactory.checkboxes.Checkbox
import br.com.uniii.padroes.criacao.abstractfactory.factories.GUIFactory


class Windows(guiFactory: GUIFactory) {

    private var button: Button = guiFactory.createButton()
    private var checkbox: Checkbox = guiFactory.createCheckbox()
    fun paint() {
        button.paint()
        checkbox.paint()
    }
}