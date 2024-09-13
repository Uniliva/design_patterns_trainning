package br.com.uniii.padroes.estrutural.facade

import br.com.uniii.padroes.estrutural.facade.BitrateReader.convert
import br.com.uniii.padroes.estrutural.facade.BitrateReader.read
import br.com.uniii.padroes.estrutural.facade.CodecFactory.extract
import java.io.File

// Encapsula as classes complexas da lib e fornece uma interface simplificada para o uso
class VideoConversionFacade {
    fun convertVideo(fileName: String?, format: String): File {
        println("VideoConversionFacade: conversion started.")
        val file = VideoFile(fileName!!)
        val sourceCodec = extract(file)
        val destinationCodec = if (format == "mp4") {
            MPEG4CompressionCodec()
        } else {
            OggCompressionCodec()
        }
        val buffer = read(file, sourceCodec)
        val intermediateResult = convert(buffer, destinationCodec)
        val result = (AudioMixer()).fix(intermediateResult)
        println("VideoConversionFacade: conversion completed.")
        return result
    }
}