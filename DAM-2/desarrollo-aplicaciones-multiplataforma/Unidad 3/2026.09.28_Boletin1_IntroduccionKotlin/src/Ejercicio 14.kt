fun main() {
    println("Introduzca una palabra para contar sus cracteres")
    val palabra = readln()

    println("$palabra tiene ${contadorDeCaracteres(palabra)} caracteres")
}

fun contadorDeCaracteres(palabra: String): Int {
    var numDecaracteres = 0;
    for (char in palabra) {
        numDecaracteres++
    }
    return numDecaracteres;
}