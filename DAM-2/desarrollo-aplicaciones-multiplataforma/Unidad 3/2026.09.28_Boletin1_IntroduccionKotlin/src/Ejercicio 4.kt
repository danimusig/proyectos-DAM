fun main() {
    var acumulador = 0.0f

    println("Introduzca las notas una a una: ")
    for (i in 1..5) {
        var num = readln().toFloat()
        acumulador+=num
    }

    val mediaNum = acumulador / 5.0f

    if (mediaNum >= 5) println("enhorabuena campeon") else println("a estudiar melon")
}