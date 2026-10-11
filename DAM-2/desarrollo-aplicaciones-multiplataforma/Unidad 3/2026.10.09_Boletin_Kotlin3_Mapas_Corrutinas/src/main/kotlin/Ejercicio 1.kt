fun main() {
    var enteros: MutableList<Int> = MutableList(10) { getRandomNum() }
    enteros.forEach { println(it) }
}

fun getRandomNum(): Int {
    return (1..9999).random()
}