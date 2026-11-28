package com.example.gestortareassql

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val listaTareas = ArrayList<Tarea>()
    private lateinit var adapter: ArrayAdapter<Tarea>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val listView = findViewById<ListView>(R.id.listViewTareas)
        val btAdd = findViewById<Button>(R.id.btAdd)

        adapter = ArrayAdapter(this, R.layout.text_color_list_view, listaTareas)
        listView.adapter = adapter

        btAdd.setOnClickListener {
            startActivity(Intent(this, AddTask::class.java))
        }

        listView.setOnItemClickListener { _, _, position, _ ->
            val tarea = listaTareas[position]
            val intent = Intent(this, ViewTask::class.java).apply {
                putExtra("id", tarea.id)
            }
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        cargarTareasBD()
    }

    private fun cargarTareasBD() {
        listaTareas.clear()
        val admin = AdminSQLiteOpenHelper(this, "agendaTareas", null, 1)
        val bd = admin.readableDatabase
        val fila = bd.rawQuery(
            "SELECT id, nombre, descripcion, fecha_vencimiento, prioridad, completada FROM tareas",
            null
        )

        if (fila.moveToFirst()) {
            do {
                listaTareas.add(
                    Tarea(
                        id = fila.getInt(0),
                        nombre = fila.getString(1),
                        descripcion = fila.getString(2) ?: "",
                        fechaVencimiento = fila.getString(3) ?: "",
                        prioridad = fila.getString(4) ?: "",
                        completada = fila.getInt(5) == 1
                    )
                )
            } while (fila.moveToNext())
        }
        fila.close()
        bd.close()
        adapter.notifyDataSetChanged()
    }
}