fun main() {
    val numArray = IntArray(10)
    inicilaizarArray(numArray)
    println("Suma de los elementos del array:  ${calculaSuma(numArray)}")
}

fun inicilaizarArray(numArray: IntArray) {
    for (i in numArray.indices) {
        val randomNumber = (1..10).random()
        numArray[i] =  randomNumber
    }
}

// Con el metodo .sum() se suman todos los numeros de un array de numeros.
fun calculaSuma(numArray: IntArray): Int {
    return numArray.sum()
}