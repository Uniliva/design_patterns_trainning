package br.com.uniii.padroes.comportamental.command.exemploGui.commands

import br.com.uniii.padroes.comportamental.command.exemploGui.editor.Editor

abstract class Command internal constructor(editor: Editor) {
    var editor: Editor = editor
    private var backup: String? = null

    fun backup() {
        backup = editor.textField?.getText()
    }

    fun undo() {
        editor.textField?.setText(backup)
    }


    abstract fun execute(): Boolean
}