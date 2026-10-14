package Ejercicio3

fun main() {
    val v1 = Vehiculo(
        "1234BCD",
        "Toyota",
        "Corolla"
    )
    val v2 = Vehiculo(
        "5678XYZ",
        "Ford",
        "Focus"
    )
    val v3 = Vehiculo(
        "9999PRT",
        "Renault",
        "Megane"
    )

    println("Comparación v1 y v2: ${v1.compareTo(v2)}")

    // validación del setter
    v3.matricula = "1234AEI" // Inválida
    v3.matricula = "1111ZZZ" // Válida

    // Gestor de licencias
    val gestor = LicenciasCirculacion(mutableMapOf())
    gestor.addVehiculo(10, v1)
    gestor.addVehiculo(20, v2)
    gestor.addVehiculo(30, v3)

    gestor.imprimirLicenciasCirculacion()

    println("\nBúsqueda:")
    gestor.imprimirVehiculo("1234BCD")
    gestor.imprimirVehiculo("999ABC")

    println("\nEliminación:")
    gestor.eliminarVehiculo("5678XYZ")

    gestor.imprimirLicenciasCirculacion()
}