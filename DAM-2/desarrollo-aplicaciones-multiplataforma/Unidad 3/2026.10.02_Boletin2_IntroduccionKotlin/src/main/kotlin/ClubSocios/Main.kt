package ClubSocios

fun main() {
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

        println(socio1.toString())
        println(socio2.toString())
}
