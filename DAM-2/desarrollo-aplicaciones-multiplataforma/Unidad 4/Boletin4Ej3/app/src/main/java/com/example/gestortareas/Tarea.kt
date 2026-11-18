package com.example.gestortareas

data class Tarea(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val fechaVencimiento: String,
    val prioridad: String,
    val completada: Boolean
) {
    override fun toString(): String {
        return "$nombre\n$fechaVencimiento"
    }
}