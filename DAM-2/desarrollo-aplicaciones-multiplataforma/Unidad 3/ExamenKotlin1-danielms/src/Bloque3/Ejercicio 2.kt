package Bloque3

fun main() {
    println("Introduzca 10 numeros uno a uno:")
    val numArray = MutableList(10) { readln().toInt() }
    var acumulador = 0
    numArray.forEach {
        if (it % 2 == 0) acumulador += it
    }

    println("La suma de los pares es $acumulador")
}