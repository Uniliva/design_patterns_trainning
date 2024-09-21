interface Mediator {
    fun notify(sender: Component, event: String)
}

abstract class Component(protected var mediator: Mediator)

class Button(mediator: Mediator) : Component(mediator) {
    fun click() {
        println("Button clicked")
        mediator.notify(this, "click")
    }
}

class TextBox(mediator: Mediator) : Component(mediator) {
    fun setText(text: String) {
        println("TextBox text: $text")
        mediator.notify(this, "textChanged")
    }

    fun clear() {
        println("TextBox cleared")
    }
}

class ConcreteMediator : Mediator {
    private var button: Button? = null
    private var textBox: TextBox? = null

    fun setButton(button: Button?) {
        this.button = button
    }

    fun setTextBox(textBox: TextBox?) {
        this.textBox = textBox
    }

    override fun notify(sender: Component, event: String) {
        if (sender === button && event == "click") {
            textBox?.clear()
        } else if (sender === textBox && event == "textChanged") {
            // Lógica adicional para o TextBox
        }
    }
}

object MediatorExample {
    @JvmStatic
    fun main(args: Array<String>) {
        val mediator = ConcreteMediator()

        val button = Button(mediator)
        val textBox = TextBox(mediator)

        mediator.setButton(button)
        mediator.setTextBox(textBox)

        button.click() // Saída: Button clicked, TextBox cleared
        textBox.setText("Hello!") // Saída: TextBox text: Hello!
    }
}