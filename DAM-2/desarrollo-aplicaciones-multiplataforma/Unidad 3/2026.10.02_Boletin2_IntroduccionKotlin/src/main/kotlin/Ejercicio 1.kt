fun main() {
    val numeros = IntArray(10)

    println("Introduzca 10 numeros para el array: ")
    for (i in numeros.indices) {
        print("Numero $i: ")
        numeros[i] = readln().toInt()
    }

    // El metodo reversed() no altera el orden del array original al contrario de reverse()
    for (i in numeros.indices.reversed()) {
        print("${numeros[i]} ")
    }
}