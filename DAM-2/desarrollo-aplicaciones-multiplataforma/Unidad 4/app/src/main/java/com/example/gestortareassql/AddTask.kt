package com.example.gestortareassql

import android.content.ContentValues
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddTask : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        val campoNombre = findViewById<EditText>(R.id.etAddNombre)
        val campoDescripcion = findViewById<EditText>(R.id.etAddDescripcion)
        val spinnerFecha = findViewById<Spinner>(R.id.spinnerFecha)
        val radioAlta = findViewById<RadioButton>(R.id.rbAlta)
        val radioMedia = findViewById<RadioButton>(R.id.rbMedia)
        val radioBaja = findViewById<RadioButton>(R.id.rbBaja)
        val checkboxCompletada = findViewById<CheckBox>(R.id.cbCompletada)
        val botonGuardar = findViewById<ImageButton>(R.id.btGuardar)
        val botonVolver = findViewById<Button>(R.id.btVolver)

        val opcionesFecha = arrayOf("Hoy", "Mañana", "Próxima semana")
        val adapterSpinner = ArrayAdapter(this, android.R.layout.simple_spinner_item, opcionesFecha)
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerFecha.adapter = adapterSpinner

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
            bd.insert("tareas", null, registro)
            bd.close()

            Toast.makeText(this, "Tarea guardada correctamente", Toast.LENGTH_SHORT).show()
            finish()
        }

        botonVolver.setOnClickListener { finish() }
    }
}