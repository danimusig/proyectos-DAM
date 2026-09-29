fun main() {
    println("Introduzca una nota para saber su calificacion correspondiente: ")
    val nota = readln().toInt()

    when (nota) {
        in 0..4 -> println("Suspenso")
        5 -> println("Aprobado")
        6 -> println("Bien")
        in 7..8 -> println("Notable")
        in 9..10 -> println("Sobresaliente")
    }
}