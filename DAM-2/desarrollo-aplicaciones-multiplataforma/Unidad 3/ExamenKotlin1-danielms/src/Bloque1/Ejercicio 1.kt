package Bloque1

fun main() {

    println("Introduzca un numero: ")
    val numUsuario = readln().toInt()
    // Solucion con when
    var letraDNI = ' '
    when (numUsuario % 23) {
        0 -> letraDNI = 'T'
        1 -> letraDNI = 'R'
        2 -> letraDNI = 'W'
        3 -> letraDNI = 'A'
        4 -> letraDNI = 'G'
        5 -> letraDNI = 'M'
        6 -> letraDNI = 'Y'
        7 -> letraDNI = 'F'
        8 -> letraDNI = 'P'
        9 -> letraDNI = 'D'
        10 -> letraDNI = 'X'
        11 -> letraDNI = 'B'
        12 -> letraDNI = 'N'
        13 -> letraDNI = 'J'
        14 -> letraDNI = 'Z'
        15 -> letraDNI = 'S'
        16 -> letraDNI = 'Q'
        17 -> letraDNI = 'V'
        18 -> letraDNI = 'H'
        19 -> letraDNI = 'L'
        20 -> letraDNI = 'C'
        21 -> letraDNI = 'K'
        22 -> letraDNI = 'E'
    }

    println("La letra del dni correspondiente al numero $numUsuario es: $letraDNI" )


    // Solucion con GET
    val caracteresDNI = "TRWAGMYFPDXBNJZSQVHLCKE"
    letraDNI = caracteresDNI[numUsuario%23];
    println("La letra del dni correspondiente al numero $numUsuario es: $letraDNI" )



}


