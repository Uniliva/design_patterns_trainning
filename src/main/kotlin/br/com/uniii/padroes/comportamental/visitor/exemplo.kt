package br.com.uniii.padroes.comportamental.visitor

interface DocumentElement {
    fun accept(visitor: DocumentVisitor)
}

class Text(val content: String) : DocumentElement {
    override fun accept(visitor: DocumentVisitor) {
        visitor.visitText(this)
    }
}

class Image(val path: String) : DocumentElement {
    override fun accept(visitor: DocumentVisitor) {
        visitor.visitImage(this)
    }
}

class Table(val rows: Int, val columns: Int) : DocumentElement {
    override fun accept(visitor: DocumentVisitor) {
        visitor.visitTable(this)
    }
}

interface DocumentVisitor {
    fun visitText(text: Text)
    fun visitImage(image: Image)
    fun visitTable(table: Table)
}

class RenderVisitor : DocumentVisitor {
    override fun visitText(text: Text) {
        println("Rendering text: ${text.content}")
    }

    override fun visitImage(image: Image) {
        println("Rendering image from: ${image.path}")
    }

    override fun visitTable(table: Table) {
        println("Rendering table with ${table.rows} rows and ${table.columns} columns")
    }
}

class ExportVisitor : DocumentVisitor {
    override fun visitText(text: Text) {
        println("Exporting text: ${text.content}")
    }

    override fun visitImage(image: Image) {
        println("Exporting image from: ${image.path}")
    }

    override fun visitTable(table: Table) {
        println("Exporting table with ${table.rows} rows and ${table.columns} columns")
    }
}

class Document(private val elements: List<DocumentElement>) {

    fun accept(visitor: DocumentVisitor) {
        elements.forEach { it.accept(visitor) }
    }
}

fun main() {
    val document = Document(listOf(
        Text("This is a text."),
        Image("/path/to/image.jpg"),
        Table(3, 5)
    ))

    val renderVisitor = RenderVisitor()
    val exportVisitor = ExportVisitor()

    println("Rendering Document:")
    document.accept(renderVisitor)

    println("\nExporting Document:")
    document.accept(exportVisitor)
}
