package dms.iessanjose.agendadecontactos

data class Contacto (
    val nombre: String,
    val telefono: String,
    val email: String
) {
    override fun toString(): String {
        return "$this.nombre \n $this.telefono"
    }
}