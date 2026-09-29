fun main() {
    println("Introduzca un numero del 1 al 9 para saber sus multiplos")
    var number = readln().toInt()

    if (number in 1..9) {
        multiplos(number)
    } else {
        println("El numero debe estar entre 1 y 9 incluidos")
    }
}

fun multiplos(number: Int, limite: Int = 100) {
    for (i in 1..limite) {
        println(number * i)
    }
}