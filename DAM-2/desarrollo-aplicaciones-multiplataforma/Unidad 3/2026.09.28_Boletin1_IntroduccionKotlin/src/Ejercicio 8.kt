fun main() {
    println("Introduzca un numero hasta el que calcular todos los multiplos de 3")
    print("Calcular hasta el numero: ")
    var numLimite = readln().toInt()

    for (i in 1..numLimite)
        if (i % 3 == 0) print("$i ")

}