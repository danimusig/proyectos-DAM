package ClubSocios

import java.time.LocalDate

open class Persona (private var nombreCompleto: Nombre, private var fechaNacimiento: Fecha, private var nif: Nif ) {

    override fun toString(): String {
        return "-Nombre: ${nombreCompleto.toString()} \n-Fecha nacimiento: ${fechaNacimiento.toString()} \n-Nif: ${nif.toString()}"
    }
}