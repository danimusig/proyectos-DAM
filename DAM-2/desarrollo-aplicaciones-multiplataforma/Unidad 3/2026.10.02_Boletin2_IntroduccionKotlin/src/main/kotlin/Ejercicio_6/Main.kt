package Ejercicio_6

fun main() {
    // Creo 2 motos una con la velocidad por defecto(0) y otra con la velocidad del parámetro.
    val moto1 = Moto(
        "1234-DWG"
    )
    val moto2 = Moto(
        "5678-JKS",
        60
    )

    // La moto 1 acelera a 35 y frena a 25
    moto1.acelear(35)
    println("La moto 1 acelera:  \n${moto1}")
    moto1.frenar(10)
    println("La moto 1 frena: \n${moto1}")

    // La moto 2 acelera de 60 a 110 y frena a 90
    moto2.acelear(50)
    println("La moto 2 acelera:  \n${moto2}")
    moto2.frenar(20)
    println("La moto 2 frena: \n${moto2}")
    // Freno 100 para probar que salta el error antes de frenar.
    moto2.frenar(100)
    println("$moto2")
}