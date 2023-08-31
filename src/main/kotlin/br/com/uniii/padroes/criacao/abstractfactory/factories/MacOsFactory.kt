package br.com.uniii.padroes.criacao.abstractfactory.factories

import br.com.uniii.padroes.criacao.abstractfactory.buttons.Button
import br.com.uniii.padroes.criacao.abstractfactory.buttons.MacOSButton
import br.com.uniii.padroes.criacao.abstractfactory.checkboxes.Checkbox
import br.com.uniii.padroes.criacao.abstractfactory.checkboxes.MacOSCheckbox

class MacOsFactory : GUIFactory {
    override fun createButton(): Button = MacOSButton()
    override fun createCheckbox(): Checkbox = MacOSCheckbox()
}