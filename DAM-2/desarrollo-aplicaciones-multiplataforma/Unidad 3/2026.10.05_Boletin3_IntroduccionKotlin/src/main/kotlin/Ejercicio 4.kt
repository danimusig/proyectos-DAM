fun main() {
    var numEJ = 200
    numEJ.divisores()
}

fun Int.divisores() {
    for (i in 1..this) {
        if (this % i == 0) println("$i es divisor de $this")
    }
}