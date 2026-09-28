fun main() {
    print("Introduce el múltiplo: ")
    val multiplo = readln().toDouble()

    print("Introduce el exponente: ")
    val potencia = readln().toInt()

    var resultado = 1.0
    for (i in 1..potencia) {
        resultado *= multiplo
    }

    println(resultado)
}