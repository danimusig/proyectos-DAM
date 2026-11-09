package com.example.agendacontactossql

data class Contacto (
    val nombre: String,
    val telefono: String,
    val email: String
) {
    override fun toString(): String {
        return "$nombre \n $telefono"
    }
}