package br.com.uniii.padroes.criacao.abstractfactory.factories

import br.com.uniii.padroes.criacao.abstractfactory.buttons.Button
import br.com.uniii.padroes.criacao.abstractfactory.buttons.WindowsButton
import br.com.uniii.padroes.criacao.abstractfactory.checkboxes.Checkbox
import br.com.uniii.padroes.criacao.abstractfactory.checkboxes.WindowsCheckbox

class WindowsFactory : GUIFactory {
    override fun createButton(): Button = WindowsButton()
    override fun createCheckbox(): Checkbox = WindowsCheckbox()
}