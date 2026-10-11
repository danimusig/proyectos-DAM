package Ejercicio2

class Asignatura (var nombre: AsignaturasDAM, var calificacion: Int) {

    override fun toString(): String {
        return "$nombre : $calificacion"
    }

}