package Bloque1

fun main() {
    var numMenor = Int.MAX_VALUE
    var numMayor = Int.MIN_VALUE

    println("Indiqe la cantidad de numeros que desea introducir: ")
    val cantNumeros = readln().toInt()

    var acumulador = 0

    for (i in  1..cantNumeros) {
        println("Introduzca un numero: ")
        val numUsuario = readln().toInt()
        if (numUsuario < numMenor) numMenor = i
        if (numUsuario > numMayor) numMayor = i
        acumulador += numUsuario
    }

    println("El numero mayor es $numMayor")
    println("El numero menor es $numMenor")
    println("La media aritmetica es ${acumulador / cantNumeros}")
}