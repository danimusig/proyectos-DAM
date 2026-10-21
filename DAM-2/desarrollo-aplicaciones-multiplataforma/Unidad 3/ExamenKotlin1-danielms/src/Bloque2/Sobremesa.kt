package Bloque2

class Sobremesa(nombreModelo: String, numSerie: Int, precio: Double, descuentoEstandar: Int = 10, modeloGrafica: String) :
    Ordenador(nombreModelo, numSerie, precio, descuentoEstandar) {

    private var modeloGrafica = modeloGrafica
        get() {
            return field
        }
        set(value) {
            field = value
        }

    override fun toString(): String {
        return super.toString() + " - Modelo de Grafica: $modeloGrafica"
    }
}