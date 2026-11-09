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

class AddContact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_contact)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val campoNombre = findViewById<EditText>(R.id.etAddNombre)
        val campoTelefono = findViewById<EditText>(R.id.etAddPhone)
        val campoEmail = findViewById<EditText>(R.id.etAddEmail)
        val botonVolver = findViewById<Button>(R.id.btAdd)
        val botonAnyadir = findViewById<Button>(R.id.btBack)

        botonAnyadir.setOnClickListener {
            val telefono = campoTelefono.text.toString()
            val nombre = campoNombre.text.toString()
            val correo = campoEmail.text.toString()

            if (telefono.isNotEmpty() && nombre.isNotEmpty()) {
                val admin = AdminSQLiteOpenHelper(this, "agendaContactos", null, 1)
                val bd = admin.writableDatabase
                val registroContacto = ContentValues().apply {
                    put("telefono", telefono)
                    put("nombre", nombre)
                    put("correo", correo)
                }
                bd.insert("Contactos", null, registroContacto)
                bd.close()

                Toast.makeText(this, "Contacto añadido correctamente", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Completa los campos requeridos", Toast.LENGTH_SHORT).show()
            }
        }

        botonVolver.setOnClickListener {
            finish()
        }
    }
}