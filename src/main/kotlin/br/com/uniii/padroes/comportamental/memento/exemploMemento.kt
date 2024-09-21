package br.com.uniii.padroes.comportamental.memento

class Editor {
    private var content: String = ""

    fun type(words: String) {
        content += words
    }

    fun getContent(): String {
        return content
    }

    // Cria um Memento (salva o estado atual)
    fun save(): Memento {
        return Memento(content)
    }

    // Restaura o estado de um Memento
    fun restore(memento: Memento) {
        content = memento.getContent()
    }

    // Memento é aninhado dentro do Originator e encapsula o estado do Editor
    class Memento(private val content: String) {
        fun getContent(): String {
            return content
        }
    }
}


class History {
    private val savedStates = mutableListOf<Editor.Memento>()

    fun saveState(editor: Editor) {
        savedStates.add(editor.save())
    }

    fun restoreState(editor: Editor) {
        if (savedStates.isNotEmpty()) {
            editor.restore(savedStates.removeAt(savedStates.size - 1))
        }
    }
}


fun main() {
    val editor = Editor()
    val history = History()

    // Editando o documento
    editor.type("This is the first sentence. ")
    editor.type("This is the second sentence. ")

    // Salvando o estado atual
    history.saveState(editor)
    println("Content before saving: " + editor.getContent())  // Saída: This is the first sentence. This is the second sentence.

    // Editando mais
    editor.type("And this is the third sentence.")
    println("Content after typing more: " + editor.getContent())  // Saída: This is the first sentence. This is the second sentence. And this is the third sentence.

    // Restaurando o estado anterior
    history.restoreState(editor)
    println("Content after undo: " + editor.getContent())  // Saída: This is the first sentence. This is the second sentence.
}
