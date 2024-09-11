package br.com.uniii.padroes.estrutural.composite

import java.awt.Color
import javax.swing.JFrame


fun main() {
    // Criando formas simples
    val circulo1 = Circulo(50, 50, 20, Color.BLUE)
    val retangulo1 = Retangulo(100, 100, 40, 60, Color.RED)

    // Criando uma forma composta que contém formas simples
    val formaComposta1 = FormaComposta()
    formaComposta1.adicionar(circulo1)
    formaComposta1.adicionar(retangulo1)

    // Criando outro composto que inclui o primeiro composto e uma nova forma
    val formaComposta2 = FormaComposta()
    val circulo2 = Circulo(200, 150, 30, Color.GREEN)
    val circulo3 = Circulo(300, 150, 30, Color.DARK_GRAY)
    formaComposta2.adicionar(formaComposta1)  // Adicionando o primeiro composto
    formaComposta2.adicionar(circulo2)        // Adicionando uma nova forma
    formaComposta2.adicionar(circulo3)        // Adicionando uma nova forma

    // Criando o JFrame e desenhando todas as formas (incluindo compostos dentro de compostos)
    criarJanela(formaComposta2)

}

fun criarJanela(formaComposta: FormaComposta) {
    val frame = JFrame("Exemplo Composite")
    val painelDesenho = PainelDesenho(formaComposta)

    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.setSize(400, 400)
    frame.add(painelDesenho)
    frame.isVisible = true
}