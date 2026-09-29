fun main() {

    var personasSinCasa = 0
    var personasConCasa = 0
    var personasConMultiplesCasas = 0

    println("Introduzca la cantidad de viviendas que tienen 10 familias")
    for (i in 1..10) {
        var numViviendas = 0
        do {
            print("Cantidad de viviendas de la familia $i:  ")
            var numViviendas = readln().toInt()
            if (numViviendas < 0) {
                println("**Alerta: El numero debe ser un entero positivo")
            }
        } while (numViviendas < 0)

        when (numViviendas) {
            0 -> personasSinCasa++
            1 -> personasConCasa++
            else -> personasConMultiplesCasas++
        }
    }

    println("** Estadísticas: " +
            "\nPersonas sin vivienda: $personasSinCasa " +
            "\nPersonas con una vivienda: $personasConCasa " +
            "\nPersonas con multiples viviendas: $personasConMultiplesCasas" )
}