fun main() {
    var num1 = 240
    var num2 = 56
    var num3 = 5
    println("Hay ${contarPares(num1,num2,num3)} numeros pares los numeros introducidos.")
}

fun contarPares(vararg numeros: Int): Int {
    var cantPares = 0
    for (num in numeros) {
        if (num % 2 == 0) cantPares++
    }
    return cantPares
}