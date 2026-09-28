fun main() {
    println("Inserta la altura de la escalera de asteriscos")
    val alturaEscalera = readln().toInt()

    var escalon = "";
    for (i in 1..alturaEscalera) {
            escalon+="*"
            println(escalon)
    }
}
