fun main() {
    println("Introduzca el numero de rectangulos: ")
    val numRectangulos = readln().toInt();

    for (i in 1..numRectangulos) {
        print("Introduzca la altura del reactangulo $i:  ")
        var altura = readln().toDouble()
        print("Introduzca la base del rectangulo $i:  ")
        var base = readln().toDouble()

        println("** Superficie del rectangulo $i = ${(base * altura)} \n")
    }
}

