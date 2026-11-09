package com.example.agendacontactossql

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ViewContact : AppCompatActivity() {

    private var telefonoKey: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_contact)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        telefonoKey = intent.getStringExtra("telefono")

        val btVolver = findViewById<Button>(R.id.btAdd)
        val btEditar = findViewById<Button>(R.id.btEditar)

        btEditar.setOnClickListener {
            val intent = Intent(this, EditContact::class.java).apply {
                putExtra("telefono", telefonoKey)
            }
            startActivity(intent)
        }

        btVolver.setOnClickListener {
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        cargarContactoBD()
    }

    private fun cargarContactoBD() {
        if (telefonoKey == null) return

        val tvTitle = findViewById<TextView>(R.id.tvTitleNombre)
        val tvName = findViewById<TextView>(R.id.tvViewName)
        val tvPhone = findViewById<TextView>(R.id.tvViewPhone)
        val tvEmail = findViewById<TextView>(R.id.etViewEmail)

        val admin = AdminSQLiteOpenHelper(this, "agendaContactos", null, 1)
        val bd = admin.readableDatabase
        val fila = bd.rawQuery("SELECT nombre, correo FROM Contactos WHERE telefono = ?", arrayOf(telefonoKey))

        if (fila.moveToFirst()) {
            val nombre = fila.getString(0)
            val correo = fila.getString(1)

            tvTitle.text = nombre
            tvName.text = nombre
            tvPhone.text = telefonoKey
            tvEmail.text = correo
        }
        fila.close()
        bd.close()
    }
}