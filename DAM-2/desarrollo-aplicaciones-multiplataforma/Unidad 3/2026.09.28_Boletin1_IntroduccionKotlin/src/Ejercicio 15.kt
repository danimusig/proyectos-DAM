fun main() {
    println(suma(1, 3, 5,4))
}

fun suma(num1:Int, num2:Int, num3: Int, num4: Int = 0, num5: Int = 0): Int {
    return num1+num2+num3+num4+num5
}