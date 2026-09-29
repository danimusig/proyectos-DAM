fun main() {

    var numMayor = Int.MIN_VALUE
    var numMenor = Int.MAX_VALUE

    println("Introduzca 10 numeros uno a uno: ")

    var acumulador = 0
    for (i in 1..10) {
        val num = readln().toInt()
        acumulador+=num

        if (num > numMayor) numMayor = num
        if (num < numMenor) numMenor = num
    }

    val media = acumulador / 10

    println("Media: $media \nMinValue= $numMenor \nMaxValue=$numMayor")
}