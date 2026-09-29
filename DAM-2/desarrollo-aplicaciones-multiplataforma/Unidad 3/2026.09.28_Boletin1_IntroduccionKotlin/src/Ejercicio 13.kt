fun main() {
    println("Introduzca un número para ver si es primo: ")
    val number = readln().toInt()

    if (number <= 0) {
        println("El número debe ser un entero positivo.")
    } else if (esPrimo(number)) {
        println("$number es un número primo.")
    } else {
        println("$number no es un número primo.")
    }
}

fun esPrimo(number: Int): Boolean {
    var divisores = 0

    for (i in 1..number) {
        if (number % i == 0) {
            divisores++
        }
    }

    return divisores == 2
}