package br.com.uniii.padroes.criacao.abstractfactory

import br.com.uniii.padroes.criacao.abstractfactory.factories.GUIFactory
import br.com.uniii.padroes.criacao.abstractfactory.factories.MacOsFactory
import br.com.uniii.padroes.criacao.abstractfactory.factories.WindowsFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import kotlin.random.Random

@SpringBootApplication
class AbstractFatoryTest {

    companion object {
        fun configureScreem(): Windows {
            val nextRandom = Random.nextBoolean()
            val gui: GUIFactory = if (nextRandom) WindowsFactory() else MacOsFactory()
            return Windows(gui)
        }
    }


}

fun main(args: Array<String>) {
    for (x in 1..10) {
        println("--------------------------------------------> Generate new Windows")
        val windows = AbstractFatoryTest.configureScreem()
        windows.paint()
    }
}