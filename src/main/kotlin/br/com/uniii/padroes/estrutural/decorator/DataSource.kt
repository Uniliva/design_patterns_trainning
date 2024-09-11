package br.com.uniii.padroes.estrutural.decorator

interface DataSource {
    fun writeData(data: String)

    fun readData(): String?
}