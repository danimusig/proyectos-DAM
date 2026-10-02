fun main() {
    val numArray = IntArray(10)
    inicilaizarArray(numArray)
    println("Resultado ${calculaSuma(numArray)}")
}

fun inicilaizarArray(numArray: IntArray): IntArray {
    for (i in numArray.indices) {
        val randomNumber = (0..10).shuffled().first()
        numArray[i] =  randomNumber;
    }

    return numArray
}


fun calculaSuma(numArray: IntArray): Int {
    var resultado = 0
    if (numArray.isEmpty()) {
        print("No hay valores que sumar.")
    } else {
        for (i in numArray.indices) {
            resultado+=numArray[i]
        }
    }
    return resultado;

}