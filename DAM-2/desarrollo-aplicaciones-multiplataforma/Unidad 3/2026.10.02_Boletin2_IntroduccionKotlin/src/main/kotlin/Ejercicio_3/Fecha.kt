package Ejercicio_3

class Fecha (diaFecha: Int, mesFecha: Int, anyoFecha: Int) {

    private var dia = diaFecha
        get() {
            return field
        }
        set(value) {
            field = value
        }
    private var mes = mesFecha
        get() {
            return field
        }
        set(value) {
            field = value
        }
    private var any = anyoFecha
        get() {
            return field
        }
        set(value) {
            field = value
        }

    override fun toString(): String {
        return "$dia/$mes/$any"
    }
}
