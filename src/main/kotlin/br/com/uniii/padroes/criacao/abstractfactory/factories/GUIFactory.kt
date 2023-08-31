package br.com.uniii.padroes.criacao.abstractfactory.factories

import br.com.uniii.padroes.criacao.abstractfactory.buttons.Button
import br.com.uniii.padroes.criacao.abstractfactory.checkboxes.Checkbox

interface GUIFactory {
    fun createButton(): Button
    fun createCheckbox(): Checkbox
}