fun main() {
    var acumuladorSuma: Double = 0.0
    var acumuladorMulti: Double = 1.0

    for (i in 1..5) {
        println("Introduzca los numeros de uno en uno")
        val num = readln().toDouble()

        acumuladorSuma += num
        acumuladorMulti *= num
    }

    println("Suma de todos los números $acumuladorSuma")
    println("Multiplicacion de todos los numeros $acumuladorMulti")
}