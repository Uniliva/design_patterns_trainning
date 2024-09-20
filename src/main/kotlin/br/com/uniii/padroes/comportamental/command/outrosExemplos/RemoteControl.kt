package br.com.uniii.padroes.comportamental.command.outrosExemplos
// 1. Interface Command
interface Command {
    fun execute()
}

// 2. Classe Receiver
class Light {
    fun turnOn() {
        println("Luz acesa")
    }

    fun turnOff() {
        println("Luz apagada")
    }
}

// 3. Implementações concretas de comandos
class TurnOnLightCommand(private val light: Light) : Command {
    override fun execute() {
        light.turnOn()
    }
}

class TurnOffLightCommand(private val light: Light) : Command {
    override fun execute() {
        light.turnOff()
    }
}

// 4. Classe Invoker
class RemoteControl {
    private var command: Command? = null

    fun setCommand(command: Command) {
        this.command = command
    }

    fun pressButton() {
        command?.execute()
    }
}

// Exemplo de uso
fun main() {
    val light = Light()

    val turnOnCommand = TurnOnLightCommand(light)
    val turnOffCommand = TurnOffLightCommand(light)

    val remote = RemoteControl()

    // Ligar a luz
    remote.setCommand(turnOnCommand)
    remote.pressButton()

    // Desligar a luz
    remote.setCommand(turnOffCommand)
    remote.pressButton()
}
