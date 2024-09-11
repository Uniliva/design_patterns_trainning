package br.com.uniii.padroes.estrutural.brigde.controles

import br.com.uniii.padroes.estrutural.brigde.devices.Device

class ControleAvancado(device: Device) : Controle(device) {
    fun mute() {
        device.volume = 0
    }
}