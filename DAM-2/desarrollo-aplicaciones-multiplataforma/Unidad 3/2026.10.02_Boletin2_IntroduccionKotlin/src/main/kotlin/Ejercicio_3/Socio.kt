package Ejercicio_3

class Socio (nombreCompleto: Nombre, fechaNacimiento: Fecha, nif: Nif, codigoSoc: String, fechaAlta: Fecha): Persona(nombreCompleto, fechaNacimiento, nif) {

    private var codigoSoc = codigoSoc
        get() {
            return field
        }
        set(value) {
            field = value
        }
    private var fechaAlta = fechaAlta
        get() {
            return field
        }
        set(value) {
            field = value
        }

    override fun toString(): String {
        return "${super.toString()} \n-Codigo de Socio: $codigoSoc \n-Fecha de Alta: $fechaAlta \n"
    }
}