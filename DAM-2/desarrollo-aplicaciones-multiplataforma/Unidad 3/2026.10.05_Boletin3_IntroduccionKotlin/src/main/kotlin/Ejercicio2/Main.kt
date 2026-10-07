package Ejercicio2

fun main() {
    var loterias = Array(10) { Loteria() } // Gracias stack overflow
    var acabadoEn1 = 0
    var acabadoEn2 = 0
    var acabadoEn3 = 0
    var acabadoEn4 = 0
    var acabadoEn5 = 0
    var acabadoEn6 = 0
    var acabadoEn7 = 0
    var acabadoEn8 = 0
    var acabadoEn9 = 0

    loterias.forEach { it.sortearLoteria() }
    loterias.forEach {
        when (it.numeroPremiado % 10) {
            1 -> acabadoEn1++
            2 -> acabadoEn2++
            3 -> acabadoEn3++
            4 -> acabadoEn4++
            5 -> acabadoEn5++
            6 -> acabadoEn6++
            7 -> acabadoEn7++
            8 -> acabadoEn8++
            9 -> acabadoEn9++
        }
    }

    println("Num acabado en 1: $acabadoEn1")
    println("Num acabado en 2: $acabadoEn2")
    println("Num acabado en 3: $acabadoEn3")
    println("Num acabado en 4: $acabadoEn4")
    println("Num acabado en 5: $acabadoEn5")
    println("Num acabado en 6: $acabadoEn6")
    println("Num acabado en 7: $acabadoEn7")
    println("Num acabado en 8: $acabadoEn8")
    println("Num acabado en 9: $acabadoEn9")
}