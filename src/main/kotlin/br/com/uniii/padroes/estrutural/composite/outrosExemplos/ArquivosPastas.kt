package br.com.uniii.padroes.estrutural.composite.outrosExemplos

// Componente abstrato
abstract class ArquivoSistema(val nome: String) {
    abstract fun mostrar()
}

// Folha: Arquivo individual
class Arquivo(nome: String) : ArquivoSistema(nome) {
    override fun mostrar() {
        println("Arquivo: $nome")
    }
}

// Composto: Pasta que pode conter outros ArquivoSistema (arquivos ou pastas)
class Pasta(nome: String) : ArquivoSistema(nome) {
    private val filhos = mutableListOf<ArquivoSistema>()

    fun adicionar(filho: ArquivoSistema) {
        filhos.add(filho)
    }

    fun remover(filho: ArquivoSistema) {
        filhos.remove(filho)
    }

    override fun mostrar() {
        println("Pasta: $nome")
        for (filho in filhos) {
            filho.mostrar()
        }
    }
}

fun main() {
    // Criando arquivos individuais
    val arquivo1 = Arquivo("Documento1.txt")
    val arquivo2 = Arquivo("Imagem.png")
    val arquivo3 = Arquivo("Apresentacao.ppt")

    // Criando pastas
    val pasta1 = Pasta("Meus Documentos")
    val pasta2 = Pasta("Imagens")

    // Adicionando arquivos e subpastas às pastas
    pasta1.adicionar(arquivo1)
    pasta2.adicionar(arquivo2)
    pasta2.adicionar(arquivo3)
    pasta1.adicionar(pasta2)  // pasta2 dentro de pasta1

    // Mostrando toda a estrutura de arquivos e pastas
    pasta1.mostrar()
}
