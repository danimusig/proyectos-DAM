package ClubSocios

import java.time.LocalDate
class Socio (nombreCompleto: Nombre, fechaNacimiento: Fecha, nif: Nif, private var codigoSoc: String, private var fechaAlta: Fecha): Persona(nombreCompleto, fechaNacimiento, nif) {

    override fun toString(): String {
        return "${super.toString()} \n -Codigo de Socio: $codigoSoc \n-Fecha de Alta: $fechaAlta"
    }
}