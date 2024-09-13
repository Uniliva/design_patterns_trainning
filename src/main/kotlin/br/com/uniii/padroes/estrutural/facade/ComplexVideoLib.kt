package br.com.uniii.padroes.estrutural.facade

import java.io.File



class VideoFile(val name: String) {
    val codecType: String = name.substring(name.indexOf(".") + 1)
}

interface Codec

class MPEG4CompressionCodec(var type: String = "mp4") : Codec

class OggCompressionCodec(var type: String = "ogg") : Codec

object CodecFactory {
    fun extract(file: VideoFile): Codec {
        val type = file.codecType
        if (type == "mp4") {
            println("CodecFactory: extracting mpeg audio...")
            return MPEG4CompressionCodec()
        } else {
            println("CodecFactory: extracting ogg audio...")
            return OggCompressionCodec()
        }
    }
}

object BitrateReader {
    fun read(file: VideoFile, codec: Codec?): VideoFile {
        println("BitrateReader: reading file...")
        return file
    }

    fun convert(buffer: VideoFile, codec: Codec?): VideoFile {
        println("BitrateReader: writing file...")
        return buffer
    }
}

class AudioMixer {
    fun fix(result: VideoFile?): File {
        println("AudioMixer: fixing audio...")
        return File("tmp")
    }
}