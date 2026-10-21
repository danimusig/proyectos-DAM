package Ejercicio3

class Vehiculo (matriculaVehiculo: String, fabricanteVehiculo: String, modeloVehiculo: String): Comparable<Vehiculo> {

    var matricula = matriculaVehiculo
        get() {
            return field
        }
        set(value) {
            val regex = Regex("(?i)^[0-9]{1,4}(?!.*(LL|CH))[BCDFGHJKLMNPRSTVWXYZ]{3}$")
            if (value.matches(regex)) {
                field = value.uppercase()
            } else {
                println("ERROR: Formato invalido de matricula española.")
            }
        }
    private var fabricante = fabricanteVehiculo
        get() {
            return field
        }
        set(value) {
            field = value
        }
    private var modelo = modeloVehiculo
        get() {
            return field
        }
        set(value) {
            field = value
        }

    override fun toString(): String {
        return "\n- Datos del vehicuo: $matricula \nFabricante: $fabricante \nModelo: $modelo"
    }

    override fun compareTo(other: Vehiculo): Int {
        return this.matricula.compareTo(other.matricula)
    }

}






