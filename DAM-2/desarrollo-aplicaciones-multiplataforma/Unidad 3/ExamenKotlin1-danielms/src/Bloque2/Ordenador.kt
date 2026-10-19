package Bloque2

open class Ordenador(nombreModelo: String, numSerie: Int, precio: Double, descuentoEstandar: Int = 10) {
    private var modelo: String = nombreModelo
        get() {
            return field
        }
        set(value) {
            field = value
        }
    private var numeroDeSerie: Int = numSerie
        get() {
            return field
        }
        set(value) {
            field = value
        }
    private var precioOrdenador: Double = precio
        get() {
            return field
        }
        set(value) {
            field = value
        }
    private val descuento: Int = descuentoEstandar
        get() {
            return field
        }

    override fun toString(): String {
        return " - Modelo : $modelo \n - Num de Serie: $numeroDeSerie \n - Precio: $precioOrdenador \n - Descuento: $descuento \n"
    }
}