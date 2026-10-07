package Ejercicio2

class Loteria(var numeroPremiado: Int) {
    constructor() : this()

    fun sortearLoteria(): Int {
            numeroPremiado = (1..99999).random()
        return numeroPremiado
    }

    fun imprimirNumeroPremiado() {
            println(numeroPremiado)
    }
}