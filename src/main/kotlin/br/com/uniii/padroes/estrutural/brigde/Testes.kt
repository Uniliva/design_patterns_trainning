package br.com.uniii.padroes.estrutural.brigde

import br.com.uniii.padroes.estrutural.brigde.controles.Controle
import br.com.uniii.padroes.estrutural.brigde.controles.ControleAvancado
import br.com.uniii.padroes.estrutural.brigde.devices.Device
import br.com.uniii.padroes.estrutural.brigde.devices.Radio
import br.com.uniii.padroes.estrutural.brigde.devices.TV

fun main() {
    testarDevice(TV())
    testarDevice(Radio())

}

fun testarDevice(device: Device){
    println("Testando com controle Basico")
    val controle = Controle(device)
    controle.ligarDesliga()
    controle.aumentarVolume()
    controle.mudarCanalCima()
    controle.reduzirVolume()
    controle.ligarDesliga()

    println("--------------------------------------------------------")
    println("Testando com controle Basico")
    val controleAvancado = ControleAvancado(device)
    controleAvancado.ligarDesliga()
    controleAvancado.mute()
    controleAvancado.aumentarVolume()
    controleAvancado.aumentarVolume()
    controleAvancado.aumentarVolume()
    controleAvancado.aumentarVolume()
    controleAvancado.aumentarVolume()
    controleAvancado.mudarCanalCima()
    controleAvancado.reduzirVolume()
    controleAvancado.ligarDesliga()


    println("--------------------------------------------------------")
}
