package br.com.uniii.padroes.criacao.factorymethod

import br.com.uniii.padroes.criacao.factorymethod.dialogs.Dialog
import br.com.uniii.padroes.criacao.factorymethod.dialogs.WebDialog
import br.com.uniii.padroes.criacao.factorymethod.dialogs.WindowsDialog
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import kotlin.random.Random

@SpringBootApplication
class Teste

fun main(args: Array<String>) {
    for (x in 1..10) {
        val nextRandom = Random.nextBoolean()
        val janela: Dialog = if (nextRandom) WebDialog() else WindowsDialog()

        janela.render()
        println()
    }

}
