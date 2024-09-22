package br.com.uniii.padroes.comportamental.state

class Order {
    var state: OrderState = NewOrderState() // Estado inicial do pedido

    fun nextState() {
        state.nextState(this)
    }

    fun previousState() {
        state.previousState(this)
    }

    fun printStatus() {
        state.printStatus()
    }
}


interface OrderState {
    fun nextState(order: Order)
    fun previousState(order: Order)
    fun printStatus()
}

// Estado Novo do Pedido
class NewOrderState : OrderState {
    override fun nextState(order: Order) {
        order.state = ProcessingOrderState()
    }

    override fun previousState(order: Order) {
        println("Pedido novo, não pode voltar.")
    }

    override fun printStatus() {
        println("O pedido é novo e ainda não foi processado.")
    }
}

// Estado de Processamento do Pedido
class ProcessingOrderState : OrderState {
    override fun nextState(order: Order) {
        order.state = ShippedOrderState()
    }

    override fun previousState(order: Order) {
        order.state = NewOrderState()
    }

    override fun printStatus() {
        println("O pedido está sendo processado.")
    }
}

// Estado de Pedido Enviado
class ShippedOrderState : OrderState {
    override fun nextState(order: Order) {
        order.state = DeliveredOrderState()
    }

    override fun previousState(order: Order) {
        order.state = ProcessingOrderState()
    }

    override fun printStatus() {
        println("O pedido foi enviado.")
    }
}

// Estado de Pedido Entregue
class DeliveredOrderState : OrderState {
    override fun nextState(order: Order) {
        println("O pedido já foi entregue. Não pode avançar para outro estado.")
    }

    override fun previousState(order: Order) {
        order.state = ShippedOrderState()
    }

    override fun printStatus() {
        println("O pedido foi entregue.")
    }
}

fun main() {
    val order = Order()

    // Pedido novo
    order.printStatus() // O pedido é novo e ainda não foi processado.

    // Avança para o estado de processamento
    order.nextState()
    order.printStatus() // O pedido está sendo processado.

    // Avança para o estado de enviado
    order.nextState()
    order.printStatus() // O pedido foi enviado.

    // Avança para o estado de entregue
    order.nextState()
    order.printStatus() // O pedido foi entregue.

    // Tentativa de avançar após a entrega
    order.nextState() // O pedido já foi entregue. Não pode avançar para outro estado.

    // Volta ao estado de enviado
    order.previousState()
    order.printStatus() // O pedido foi enviado.
}
