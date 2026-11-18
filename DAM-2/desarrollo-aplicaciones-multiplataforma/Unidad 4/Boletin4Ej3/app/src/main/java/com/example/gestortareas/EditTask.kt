package com.example.gestortareas

import android.content.ContentValues
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditTask : AppCompatActivity() {

    private var idTarea: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_task)

        val campoNombre = findViewById<EditText>(R.id.etEditNombre)
        val campoDescripcion = findViewById<EditText>(R.id.etEditDescripcion)
        val spinnerFecha = findViewById<Spinner>(R.id.spinnerEditFecha)
        val radioAlta = findViewById<RadioButton>(R.id.rbEditAlta)
        val radioMedia = findViewById<RadioButton>(R.id.rbEditMedia)
        val radioBaja = findViewById<RadioButton>(R.id.rbEditBaja)
        val checkboxCompletada = findViewById<CheckBox>(R.id.cbEditCompletada)
        val botonGuardar = findViewById<Button>(R.id.btGuardarCambios)
        val botonVolver = findViewById<Button>(R.id.btVolver)

        val opcionesFecha = arrayOf("Hoy", "Mañana", "Próxima semana")
        val adapterSpinner = ArrayAdapter(this, android.R.layout.simple_spinner_item, opcionesFecha)
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerFecha.adapter = adapterSpinner

        idTarea = intent.getIntExtra("id", -1)
        cargarDatos(campoNombre, campoDescripcion, spinnerFecha, radioAlta, radioMedia, radioBaja, checkboxCompletada)

        botonGuardar.setOnClickListener {
            val nombre = campoNombre.text.toString().trim()
            val descripcion = campoDescripcion.text.toString().trim()
            val fecha = spinnerFecha.selectedItem.toString()
            val prioridad = when {
                radioAlta.isChecked -> "Alta"
                radioMedia.isChecked -> "Media"
                radioBaja.isChecked -> "Baja"
                else -> "Media"
            }
            val completada = if (checkboxCompletada.isChecked) 1 else 0

            if (nombre.isEmpty()) {
                Toast.makeText(this, "El nombre de la tarea es obligatorio", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val admin = AdminSQLiteOpenHelper(this, "agendaTareas", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues().apply {
                put("nombre", nombre)
                put("descripcion", descripcion)
                put("fecha_vencimiento", fecha)
                put("prioridad", prioridad)
                put("completada", completada)
            }
            val filasModificadas = bd.update("tareas", registro, "id = ?", arrayOf(idTarea.toString()))
            bd.close()

            if (filasModificadas > 0) {
                Toast.makeText(this, "Tarea actualizada correctamente", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "No se pudo actualizar la tarea", Toast.LENGTH_SHORT).show()
            }
        }

        botonVolver.setOnClickListener { finish() }
    }

    private fun cargarDatos(
        campoNombre: EditText,
        campoDescripcion: EditText,
        spinnerFecha: Spinner,
        radioAlta: RadioButton,
        radioMedia: RadioButton,
        radioBaja: RadioButton,
        checkboxCompletada: CheckBox
    ) {
        if (idTarea == -1) return

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

            campoNombre.setText(nombre)
            campoDescripcion.setText(descripcion)

            val adapter = spinnerFecha.adapter
            for (i in 0 until adapter.count) {
                if (adapter.getItem(i).toString() == fecha) {
                    spinnerFecha.setSelection(i)
                    break
                }
            }

            when (prioridad) {
                "Alta" -> radioAlta.isChecked = true
                "Media" -> radioMedia.isChecked = true
                "Baja" -> radioBaja.isChecked = true
            }
            checkboxCompletada.isChecked = completada
        }
        fila.close()
        bd.close()
    }
}