package Ejercicio2

fun main() {
    var loterias = Array(10) { Loteria() }
    loterias.forEach { it.sortearLoteria() }

    var acabadosEn = IntArray(10)
    loterias.forEach {
        when (it.numeroPremiado % 10) {
            0 -> acabadosEn[0]++
            1 -> acabadosEn[1]++
            2 -> acabadosEn[2]++
            3 -> acabadosEn[3]++
            4 -> acabadosEn[4]++
            5 -> acabadosEn[5]++
            6 -> acabadosEn[6]++
            7 -> acabadosEn[7]++
            8 -> acabadosEn[8]++
            9 -> acabadosEn[9]++
        }
    }

    for (i in acabadosEn.indices) println("Numeros acabados en $i: ${acabadosEn[i]}" )
}