package Ejercicio_3

class Nif (numNif: Int, letraNif: Char) {

    private var nif = numNif
        get() {
            return field
        }
        set(value) {
            field = value
        }
    private var letra = letraNif
        get() {
            return field
        }
        set(value) {
            field = value
        }

    override fun toString(): String {
        return "$nif$letra"
    }
}
