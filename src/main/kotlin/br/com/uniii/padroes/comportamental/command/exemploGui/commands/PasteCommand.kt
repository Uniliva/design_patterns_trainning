package br.com.uniii.padroes.comportamental.command.exemploGui.commands

import br.com.uniii.padroes.comportamental.command.exemploGui.editor.Editor

class PasteCommand(editor: Editor) : Command(editor) {
    override fun execute(): Boolean {
        if (editor.clipboard == null || editor.clipboard!!.isEmpty()) return false

        backup()
        editor.textField!!.insert(editor.clipboard, editor.textField!!.caretPosition)
        return true
    }
}