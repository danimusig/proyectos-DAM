package Ejercicio_3

fun main() {
        // Creo 2 socios
        val socio1 = Socio(
            Nombre("Daniel", "Muñoz"),
            Fecha(24, 8, 2000),
            Nif(12345678, 'A'),
            "A-001",
            Fecha(1,2,2003)
        )
        val socio2 = Socio(
            Nombre("Francisco", "Lobo"),
            Fecha(5,6,1980),
            Nif(12345678,'B'),
            "B-001",
            Fecha(20,4,1970)
        )

        // Añado los socios a un array de socios
        var socios: Array<Socio> = arrayOf(socio1, socio2)

        // Los imprimo con un for
        for (i in socios.indices) {
            println("Datos del socio: \n${socios[i]}") // En kotlin no hace falta llamar tostring en una plantilla
        }
}
