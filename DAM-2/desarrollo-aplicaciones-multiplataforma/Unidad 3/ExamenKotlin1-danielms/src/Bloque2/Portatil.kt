package Bloque2

class Portatil(nombreModelo: String, numSerie: Int, precio: Double, descuentoEstandar: Int = 10, peso: Int, resolucion: Resolucion) :
    Ordenador(nombreModelo, numSerie, precio, descuentoEstandar) {
    private var peso = peso
        get() {
            return field
        }
        set(value) {
            field = value
        }
    private var resolucion = resolucion
        get() {
            return field
        }
        set(value) {
            field = value
        }

    override fun toString(): String {
        return super.toString() + " - Peso: $peso \n - Resolucion: $resolucion"
    }
}