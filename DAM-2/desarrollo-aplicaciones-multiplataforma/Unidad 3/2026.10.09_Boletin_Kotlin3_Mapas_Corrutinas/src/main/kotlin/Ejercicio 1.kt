fun main() {
    var enteros: MutableList<Int> = MutableList(10) { getRandomNum() }
}

fun getRandomNum(): Int {
    return Math.random().toInt()
}