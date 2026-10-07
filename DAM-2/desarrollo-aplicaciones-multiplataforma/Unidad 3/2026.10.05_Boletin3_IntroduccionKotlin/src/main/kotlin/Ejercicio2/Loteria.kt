package Ejercicio2

class Loteria(var numeroPremiado: Int = 0) {

    fun sortearLoteria() {
            numeroPremiado = (1..99999).random()
    }

    fun imprimirNumeroPremiado() {
            println(numeroPremiado)
    }
}