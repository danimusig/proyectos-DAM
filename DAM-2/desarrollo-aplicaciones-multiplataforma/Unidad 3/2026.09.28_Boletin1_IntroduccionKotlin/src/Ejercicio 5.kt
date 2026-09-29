fun main() {
    val rangoNum = 1..9999
    println("Introduzca un numero comprendido entre 1 y 9999 para contar sus digitos: ")
    var num = readln().toInt()

    if (num !in rangoNum) {
        println("Numero fuera del rango 1 - 9999")
    } else {
        var cociente = num
        var numDigitos = 1
        while (cociente / 10 != 0) {
            cociente/=10
            numDigitos++
        }
        println("$num contiene $numDigitos digitos." );

    }
}

