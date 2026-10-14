package `Ejercicio 3`

class LicenciasCirculacion (var licencias: MutableMap<Int, Vehiculo>) {

    fun addVehiculo (numLicencia: Int, vehiculo: Vehiculo) {
        licencias[numLicencia] = vehiculo
    }

    fun imprimirVehiculo(matricula: String) {
        val regex = Regex("(?i)^[0-9]{1,4}(?!.*(LL|CH))[BCDFGHJKLMNPRSTVWXYZ]{3}$")
        if (matricula.matches(regex)) {
            val vehiculoAMostrar = licencias.values.find { it.matricula == matricula }
            if (vehiculoAMostrar != null) {
                    println(vehiculoAMostrar)
            } else {
                println("ERROR: No existe ningun vehiculo licenciado con esa matricula.")
            }
        } else {
            println("ERROR: Formato invalido de matricula española.")
        }
    }

    fun imprimirLicenciasCirculacion() {
        println("// Vehiculos registrados //")
        licencias.forEach { (i, vehiculo) ->  println("Licencia $i: $vehiculo")}
    }

    fun eliminarVehiculo(matricula: String) {
        val regex = Regex("(?i)^[0-9]{1,4}(?!.*(LL|CH))[BCDFGHJKLMNPRSTVWXYZ]{3}$")
        if (matricula.matches(regex)) {
            val vehiculoABorrar = licencias.entries.find { it.value.matricula == matricula }
            if (vehiculoABorrar != null) {
                licencias.remove(vehiculoABorrar.key)
            } else {
                println("ERROR: No existe ningun vehiculo licenciado con esa matricula.")
            }
        } else {
            println("ERROR: Formato invalido de matricula española.")
        }
    }


}