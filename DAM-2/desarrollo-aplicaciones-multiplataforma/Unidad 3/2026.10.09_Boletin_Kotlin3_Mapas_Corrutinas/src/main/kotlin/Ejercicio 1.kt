fun main() {
    var enteros: MutableList<Int> = MutableList(10) { (1..9999).random() }
    enteros.forEach { println(it) }
}
