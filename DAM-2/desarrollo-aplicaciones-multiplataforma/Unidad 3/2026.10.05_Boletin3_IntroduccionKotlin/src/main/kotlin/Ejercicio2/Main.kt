package Ejercicio2

fun main() {
    val loterias = arrayOf<Loteria>()
    for (i in 0..9) {
        val loteriaTemp = Loteria()
        loterias.set(i,  loteriaTemp)
    }

    for (i in loterias) {}

}