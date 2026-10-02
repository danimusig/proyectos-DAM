package ClubSocios

class Nombre (private var nombre: String, private var apellido: String) {

    override fun toString(): String {
        return "$nombre $apellido"
    }

}
