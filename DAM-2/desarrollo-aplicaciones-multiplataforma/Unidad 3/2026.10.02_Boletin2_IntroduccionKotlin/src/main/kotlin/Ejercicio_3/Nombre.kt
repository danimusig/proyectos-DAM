package Ejercicio_3

class Nombre (nombre: String, apellido: String) {

    private var nombre = nombre
        get() {
            return field
        }
        set(value) {
            field = value
        }
    private var apellido = apellido
        get() {
            return field
        }
        set(value) {
            field = value
        }

    override fun toString(): String {
        return "$nombre $apellido"
    }
}
