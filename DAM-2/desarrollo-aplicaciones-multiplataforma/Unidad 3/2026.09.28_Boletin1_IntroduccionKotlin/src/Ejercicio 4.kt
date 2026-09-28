fun main() {
    var acumulador = 0

    println("Introduzca las notas una a una: ")
    for (i in 1..5) {
        var num = readln().toInt()
        acumulador+=num
    }

    val mediaNum = acumulador / 5

    if (mediaNum >= 5) println("enhorabuena campeon") else println("a estudiar melon")
}