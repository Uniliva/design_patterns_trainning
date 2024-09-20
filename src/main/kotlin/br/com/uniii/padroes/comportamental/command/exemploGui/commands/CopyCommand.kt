package br.com.uniii.padroes.comportamental.command.exemploGui.commands

import br.com.uniii.padroes.comportamental.command.exemploGui.editor.Editor

class CopyCommand(editor: Editor) : Command(editor) {
    override fun execute(): Boolean {
        editor.clipboard = editor.textField!!.selectedText
        return false
    }
}