package br.com.uniii.padroes.estrutural.decorator

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.util.*
import java.util.zip.Deflater
import java.util.zip.DeflaterOutputStream
import java.util.zip.InflaterInputStream


class CompressionDecorator(
    source: DataSource
) : DataSourceDecorator(source) {
    var compressionLevel: Int = 6

    override fun writeData(data: String) {
        super.writeData(compress(data)!!)
    }

    override fun readData(): String? {
        return decompress(super.readData())
    }

    private fun compress(stringData: String): String? {
        val data = stringData.toByteArray()
        try {
            val bout = ByteArrayOutputStream(512)
            val dos = DeflaterOutputStream(bout, Deflater(compressionLevel))
            dos.write(data)
            dos.close()
            bout.close()
            return Base64.getEncoder().encodeToString(bout.toByteArray())
        } catch (ex: IOException) {
            return null
        }
    }

    private fun decompress(stringData: String?): String? {
        val data: ByteArray = Base64.getDecoder().decode(stringData)
        try {
            val `in`: InputStream = ByteArrayInputStream(data)
            val iin = InflaterInputStream(`in`)
            val bout = ByteArrayOutputStream(512)
            var b: Int
            while ((iin.read().also { b = it }) != -1) {
                bout.write(b)
            }
            `in`.close()
            iin.close()
            bout.close()
            return String(bout.toByteArray())
        } catch (ex: IOException) {
            return null
        }
    }
}