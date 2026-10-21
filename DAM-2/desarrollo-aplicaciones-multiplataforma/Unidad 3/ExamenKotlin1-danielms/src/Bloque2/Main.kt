package Bloque2

fun main() {
    val sobremesa = Sobremesa(
        "Lenovo Legion",
        numSerie = 1,
        precio = 1250.0,
        modeloGrafica = "RX6650 XT",
    )

    val portatil = Portatil(
        nombreModelo = "Thinkpad L14 Gen 2",
        numSerie = 2,
        precio = 500.50,
        descuentoEstandar = 20,
        peso = 1300,
        resolucion = Resolucion(
            1920,
            1080
        )
    )

    println(portatil.toString())
    println(sobremesa.toString())

}