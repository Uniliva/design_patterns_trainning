package br.com.uniii.padroes.estrutural.decorator

import java.io.File
import java.io.FileOutputStream
import java.io.FileReader
import java.io.IOException


class FileDataSource(private val name: String) : DataSource {
    override fun writeData(data: String) {
        val file = File(name)
        try {
            FileOutputStream(file).use { fos ->
                fos.write(data.toByteArray(), 0, data.length)
            }
            println("Arquivo salvo com sucesso: $file")
        } catch (e: IOException) {
            println("Erro ao salvar o arquivo: ${e.message}")
            e.printStackTrace()
        } catch (e: Exception) {
            println("Erro inesperado: ${e.message}")
            e.printStackTrace()
        }
    }

    override fun readData(): String {
        var buffer: CharArray? = null
        val file = File(name)
        try {
            FileReader(file).use { reader ->
                buffer = CharArray(file.length().toInt())
                buffer?.let { reader.read(it) }
            }
        } catch (ex: IOException) {
            println(ex.message)
        }
        return String(buffer!!)
    }
}