package com.example.agendacontactossql

import android.content.ContentValues
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EditContact : AppCompatActivity() {

    private var telefonoOriginal: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_contact)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val campoNombre = findViewById<EditText>(R.id.etEditNombre)
        val campoTelefono = findViewById<EditText>(R.id.etEditPhone)
        val campoEmail = findViewById<EditText>(R.id.etEditEmail)
        val botonVolver = findViewById<Button>(R.id.btVolver)
        val botonGuardar = findViewById<Button>(R.id.btGuardarCambios)

        telefonoOriginal = intent.getStringExtra("telefono")
        cargarDatos(campoNombre, campoTelefono, campoEmail)

        botonGuardar.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "agendaContactos", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues().apply {
                put("telefono", campoTelefono.text.toString())
                put("nombre", campoNombre.text.toString())
                put("correo", campoEmail.text.toString())
            }

            val filasModificadas = bd.update("Contactos", registro, "telefono = ?", arrayOf(telefonoOriginal))
            bd.close()

            if (filasModificadas == 1) {
                Toast.makeText(this, "Contacto actualizado correctamente", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "No se pudo actualizar el contacto", Toast.LENGTH_SHORT).show()
            }
        }

        botonVolver.setOnClickListener {
            finish()
        }
    }

    private fun cargarDatos(campoNombre: EditText, campoTelefono: EditText, campoEmail: EditText) {
        if (telefonoOriginal == null) return

        val admin = AdminSQLiteOpenHelper(this, "agendaContactos", null, 1)
        val bd = admin.readableDatabase
        val fila = bd.rawQuery("SELECT nombre, correo FROM Contactos WHERE telefono = ?", arrayOf(telefonoOriginal))

        if (fila.moveToFirst()) {
            campoNombre.setText(fila.getString(0))
            campoTelefono.setText(telefonoOriginal)
            campoEmail.setText(fila.getString(1))
        }
        fila.close()
        bd.close()
    }
}