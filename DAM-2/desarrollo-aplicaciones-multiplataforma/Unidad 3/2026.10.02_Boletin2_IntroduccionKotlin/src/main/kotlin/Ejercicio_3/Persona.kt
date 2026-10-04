package Ejercicio_3

open class Persona (nombreCompleto: Nombre, fechaNacimiento: Fecha, nif: Nif ) {

    private var nombreCompleto = nombreCompleto
        get() {
            return field
        }
        set(value) {
            field = value
        }
    private var fechaNacimiento = fechaNacimiento
        get() {
            return field
        }
        set(value) {
            field = value
        }
    private var nif = nif
        get() {
            return field
        }
        set(value) {
            field = value
        }

    override fun toString(): String {
        return "-Nombre: $nombreCompleto \n-Fecha nacimiento: $fechaNacimiento \n-Nif: $nif"
    }
}