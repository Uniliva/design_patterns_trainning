package br.com.uniii.padroes.criacao.factorymethod.buttons

interface Button  {
    fun render()
    fun onClick(f: () -> Unit)
}