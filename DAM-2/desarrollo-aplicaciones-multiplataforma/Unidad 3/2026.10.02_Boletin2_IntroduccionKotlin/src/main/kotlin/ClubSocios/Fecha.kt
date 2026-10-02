package ClubSocios

class Fecha (private var dia: Int, private var mes: Int, private var any: Int) {

    override fun toString(): String {
        return "$dia/$mes/$any"
    }

}
