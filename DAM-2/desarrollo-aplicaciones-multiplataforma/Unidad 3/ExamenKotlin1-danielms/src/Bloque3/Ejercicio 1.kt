package Bloque3

fun main() {
    println("Introduzca 10 numeros uno a uno:")
    val numArray = IntArray(10) { readln().toInt() }
    numArray.forEach {
        if (it % 2 == 0) println("$it es par.")
    }

    if (numArray.all { it >= 0 }) {
        println("Todos los numeros son positivos.")
    } else {
        println("Hay numeros negativos")
    }
}