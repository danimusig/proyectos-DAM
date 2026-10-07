fun main() {
    println("Introduzca los 25 numeros uno a uno")
    val arrayNum = IntArray(25) { readln().toInt() }

    if (arrayNum.all {it < 100}) {
        println("Todos los números son menores a 100")
    }

    arrayNum.forEach {
        if (it > 10) println(it)
    }
}
