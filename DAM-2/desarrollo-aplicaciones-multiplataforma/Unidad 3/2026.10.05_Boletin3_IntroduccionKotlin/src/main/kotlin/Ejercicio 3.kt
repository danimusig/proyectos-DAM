fun main() {
    var cadenaEj = "Por fin entiendo las lambda(creo)"
    println("La cadena '$cadenaEj' tiene ${cadenaEj.contarCaracteres()} caracteres.")
}

fun String.contarCaracteres(): Int {
    return this.toList().count()
}