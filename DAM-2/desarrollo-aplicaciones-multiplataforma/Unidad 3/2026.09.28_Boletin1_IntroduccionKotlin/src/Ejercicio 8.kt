fun main() {
    println("Introduzca un numero hasta el que calcular todos los multiplos de 3")
    print("Calcular hasta el numero: ")
    var numLimite = readln().toInt()

    var contadorMultiplo = 0;
    for (i in 1..numLimite) {
        if (i % 3 == 0) contadorMultiplo++
    }
    println("$numLimite tiene $contadorMultiplo multiplos de 3.")

}