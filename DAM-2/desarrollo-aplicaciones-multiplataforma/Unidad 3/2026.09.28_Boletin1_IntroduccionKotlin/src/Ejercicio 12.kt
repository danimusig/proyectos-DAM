fun main() {

    var personasSinCasa = 0
    var personasConCasa = 0
    var personasConMultiplesCasas = 0

    println("Introduzca la cantidad de viviendas que tienen 10 familias")
    for (i in 1..10) {
        print("Cantidad de viviendas de la familia $i:  ")
        var numViviendas = readln().toInt()

        when (nota) {
            0 -> personasSinCasa++
            1 -> personasConCasa++
            nota >= 2 -> personasConMultiplesCasas++
        }
    }

    println("Cantidad de viviendas: \nPersonas sin Casa: $personasSinCasa \nPersonas Con Casa: $personasConCasa \nPersonas con multiples casa")

}