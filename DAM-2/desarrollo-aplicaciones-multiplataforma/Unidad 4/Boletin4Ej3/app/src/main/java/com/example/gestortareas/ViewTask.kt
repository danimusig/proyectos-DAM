package com.example.gestortareas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class ViewTask : AppCompatActivity() {

    private var idTarea: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_task)

        idTarea = intent.getIntExtra("id", -1)

        val btEditar = findViewById<Button>(R.id.btEditar)
        val btEliminar = findViewById<Button>(R.id.btEliminar)
        val btVolver = findViewById<Button>(R.id.btVolver)

        btEditar.setOnClickListener {
            if (idTarea != -1) {
                val intent = Intent(this, EditTask::class.java).apply {
                    putExtra("id", idTarea)
                }
                startActivity(intent)
            }
        }

        btEliminar.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Eliminar tarea")
                .setMessage("¿Seguro que quieres eliminar esta tarea?")
                .setPositiveButton("Sí") { _, _ -> eliminarTarea() }
                .setNegativeButton("No", null)
                .show()
        }

        btVolver.setOnClickListener { finish() }
    }

    override fun onResume() {
        super.onResume()
        cargarTareaBD()
    }

    private fun cargarTareaBD() {
        if (idTarea == -1) return

        val tvTitulo = findViewById<TextView>(R.id.tvTituloTarea)
        val tvNombre = findViewById<TextView>(R.id.tvViewNombre)
        val tvDescripcion = findViewById<TextView>(R.id.tvViewDescripcion)
        val tvFecha = findViewById<TextView>(R.id.tvViewFecha)
        val tvPrioridad = findViewById<TextView>(R.id.tvViewPrioridad)
        val tvCompletada = findViewById<TextView>(R.id.tvViewCompletada)

        val admin = AdminSQLiteOpenHelper(this, "agendaTareas", null, 1)
        val bd = admin.readableDatabase
        val fila = bd.rawQuery(
            "SELECT nombre, descripcion, fecha_vencimiento, prioridad, completada FROM tareas WHERE id = ?",
            arrayOf(idTarea.toString())
        )

        if (fila.moveToFirst()) {
            val nombre = fila.getString(0)
            val descripcion = fila.getString(1) ?: ""
            val fecha = fila.getString(2) ?: ""
            val prioridad = fila.getString(3) ?: ""
            val completada = fila.getInt(4) == 1

            tvTitulo.text = nombre
            tvNombre.text = nombre
            tvDescripcion.text = if (descripcion.isEmpty()) "(Sin descripción)" else descripcion
            tvFecha.text = fecha
            tvPrioridad.text = prioridad
            tvCompletada.text = if (completada) "Sí" else "No"
        }
        fila.close()
        bd.close()
    }

    private fun eliminarTarea() {
        if (idTarea == -1) return

        val admin = AdminSQLiteOpenHelper(this, "agendaTareas", null, 1)
        val bd = admin.writableDatabase
        val filasEliminadas = bd.delete("tareas", "id = ?", arrayOf(idTarea.toString()))
        bd.close()

        if (filasEliminadas > 0) {
            Toast.makeText(this, "Tarea eliminada correctamente", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            Toast.makeText(this, "No se pudo eliminar la tarea", Toast.LENGTH_SHORT).show()
        }
    }
}