package br.com.uniii.padroes.estrutural.decorator

abstract class DataSourceDecorator(
    private val wrapper: DataSource
) : DataSource {
    override fun writeData(data: String) {
        wrapper.writeData(data)
    }

    override fun readData(): String? {
        return wrapper.readData()
    }
}