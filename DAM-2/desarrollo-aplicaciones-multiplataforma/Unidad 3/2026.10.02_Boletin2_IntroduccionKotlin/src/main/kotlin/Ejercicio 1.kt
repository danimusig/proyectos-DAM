fun main() {
    val numeros = IntArray(10)

    println("Introduzca 10 numeros para el array: ")
    for (i in numeros.indices) {
        print("Numero $i: ")
        numeros[i] = readln().toInt()
    }

    numeros.reverse()

    for (i in numeros.indices) {
        print("${numeros[i]} ")
    }
}