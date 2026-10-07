fun main() {
    var cadenaEj = "Por fin entiendo las lambda(creo)"
    println("La cadena '$cadenaEj' tiene ${cadenaEj.contarVocales()} vocales.")
}

fun String.contarVocales(): Int {
    val vocales = charArrayOf('a', 'e', 'i', 'o', 'u')
    var cantVocales = 0
    this.forEach { if (vocales.contains(it)) cantVocales++}
    return cantVocales
}