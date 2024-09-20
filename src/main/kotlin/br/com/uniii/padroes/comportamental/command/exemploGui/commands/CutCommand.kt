package br.com.uniii.padroes.comportamental.command.exemploGui.commands

import br.com.uniii.padroes.comportamental.command.exemploGui.editor.Editor

class CutCommand(editor: Editor) : Command(editor) {
    override fun execute(): Boolean {
        if (editor.textField!!.selectedText.isEmpty()) return false

        backup()
        val source = editor.textField!!.text
        editor.clipboard = editor.textField!!.selectedText
        editor.textField!!.text = cutString(source)
        return true
    }

    private fun cutString(source: String): String {
        val start = source.substring(0, editor.textField!!.selectionStart)
        val end = source.substring(editor.textField!!.selectionEnd)
        return start + end
    }
}