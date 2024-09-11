package br.com.uniii.padroes.estrutural.decorator


fun main(args: Array<String>) {
    val salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000"
    val arquivo = FileDataSource("dados.txt")
    val encoded = CompressionDecorator(EncryptionDecorator(arquivo))
    encoded.writeData(salaryRecords)

    println("- Input ----------------")
    println(salaryRecords)
    println("- Encoded --------------")
    println(arquivo.readData())
    println("- Decoded --------------")
    println(encoded.readData())
}