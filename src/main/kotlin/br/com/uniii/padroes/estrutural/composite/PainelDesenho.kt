package br.com.uniii.padroes.estrutural.composite

import java.awt.Graphics
import javax.swing.JPanel

class PainelDesenho(val formaComposta: FormaComposta) : JPanel() {
    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        formaComposta.desenhar(g)  // Desenha todas as formas compostas
    }
}