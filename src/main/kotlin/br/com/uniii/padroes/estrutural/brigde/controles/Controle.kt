package br.com.uniii.padroes.estrutural.brigde.controles

import br.com.uniii.padroes.estrutural.brigde.devices.Device

open class Controle(val device: Device) {

    fun ligarDesliga() {

        println("Ligando ou Deligando")
        device.ligado = !device.ligado
        device.status()
    }

    fun aumentarVolume() {
        println("Aumentado volumer!!")
        device.volume += 10
        device.status()
    }

    fun reduzirVolume() {
        println("Reduzir volumer!!")
        device.volume -= 10
        device.status()
    }

    fun mudarCanalCima() {
        println("Mudando canal Cima")
        device.canal += 1
        device.status()
    }


    fun mudarCanalbaixo() {
        println("Mudando canal Baixo")
        device.canal -= 1
        device.status()
    }

}