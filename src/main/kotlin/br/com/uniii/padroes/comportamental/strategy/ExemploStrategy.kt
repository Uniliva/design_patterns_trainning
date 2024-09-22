package br.com.uniii.padroes.comportamental.strategy

interface SortStrategy {
    fun sort(numbers: List<Int>): List<Int>
}

// Implementação da estratégia de Bubble Sort
class BubbleSortStrategy : SortStrategy {
    override fun sort(numbers: List<Int>): List<Int> {
        val list = numbers.toMutableList()
        for (i in 0 until list.size - 1) {
            for (j in 0 until list.size - i - 1) {
                if (list[j] > list[j + 1]) {
                    val temp = list[j]
                    list[j] = list[j + 1]
                    list[j + 1] = temp
                }
            }
        }
        println("Ordenado usando Bubble Sort")
        return list
    }
}

// Implementação da estratégia de Quick Sort
class QuickSortStrategy : SortStrategy {
    override fun sort(numbers: List<Int>): List<Int> {
        if (numbers.size < 2) {
            return numbers
        }
        val pivot = numbers[numbers.size / 2]
        val equal = numbers.filter { it == pivot }
        val less = numbers.filter { it < pivot }
        val greater = numbers.filter { it > pivot }
        println("Ordenado usando Quick Sort")
        return sort(less) + equal + sort(greater)
    }
}


class Sorter(private var strategy: SortStrategy) {

    // Define a estratégia a ser usada
    fun setStrategy(strategy: SortStrategy) {
        this.strategy = strategy
    }

    // Executa a ordenação usando a estratégia definida
    fun sort(numbers: List<Int>): List<Int> {
        return strategy.sort(numbers)
    }
}


fun main() {
    val numbers = listOf(64, 34, 25, 12, 22, 11, 90)

    // Usando a estratégia de Bubble Sort
    val bubbleSorter = Sorter(BubbleSortStrategy())
    println("Bubble Sort: ${bubbleSorter.sort(numbers)}")

    // Mudando para a estratégia de Quick Sort
    bubbleSorter.setStrategy(QuickSortStrategy())
    println("Quick Sort: ${bubbleSorter.sort(numbers)}")
}
