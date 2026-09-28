fun main() {

    var numMayor = Int.MAX_VALUE
    var numMenor = Int.MIN_VALUE

    println("Introduzca 10 numeros uno a uno: ")

    var acumulador = 0
    for (i in 1..10) {
        val num = readln().toInt()
        acumulador+=num

        if (num > numMenor) numMenor = num

        if (num < numMayor) numMayor = num
    }

    val media = acumulador / 10

    println("Media: $media \nMinValue= $numMenor \nMaxValue=$numMayor")
}