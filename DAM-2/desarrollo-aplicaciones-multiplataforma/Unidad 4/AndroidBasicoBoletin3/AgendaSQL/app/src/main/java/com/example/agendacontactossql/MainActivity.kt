package com.example.agendacontactossql

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val listaContactos = ArrayList<Contacto>()
    private lateinit var adapter: ArrayAdapter<Contacto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listView = findViewById<ListView>(R.id.listViewContactos)
        val btAdd = findViewById<Button>(R.id.btAdd)

        adapter = ArrayAdapter(this, R.layout.text_color_list_view, listaContactos)
        listView.adapter = adapter

        btAdd.setOnClickListener {
            startActivity(Intent(this, AddContact::class.java))
        }

        listView.setOnItemClickListener { _, _, position, _ ->
            val contacto = listaContactos[position]
            val intent = Intent(this, ViewContact::class.java).apply {
                putExtra("telefono", contacto.telefono)
            }
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        cargarContactosBD()
    }

    private fun cargarContactosBD() {
        listaContactos.clear()
        val admin = AdminSQLiteOpenHelper(this, "agendaContactos", null, 1)
        val bd = admin.readableDatabase
        val fila = bd.rawQuery("SELECT telefono, nombre, correo FROM Contactos", null)

        if (fila.moveToFirst()) {
            do {
                val telefono = fila.getString(0)
                val nombre = fila.getString(1)
                val correo = fila.getString(2)
                listaContactos.add(Contacto(nombre, telefono, correo))
            } while (fila.moveToNext())
        }
        fila.close()
        bd.close()
        adapter.notifyDataSetChanged()
    }
}