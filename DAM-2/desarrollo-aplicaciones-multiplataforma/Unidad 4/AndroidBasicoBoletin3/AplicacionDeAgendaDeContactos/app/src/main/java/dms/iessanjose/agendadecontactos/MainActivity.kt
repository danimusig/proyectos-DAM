package dms.iessanjose.agendadecontactos

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val listaContactos = ArrayList<Contacto>()
    private lateinit var adapter: ArrayAdapter<Contacto>

    private val addContactLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            val nombre = data?.getStringExtra("nombre") ?: ""
            val telefono = data?.getStringExtra("telefono") ?: ""
            val email = data?.getStringExtra("email") ?: ""
            if (nombre.isNotEmpty()) {
                listaContactos.add(Contacto(nombre, telefono, email))
                adapter.notifyDataSetChanged()
            }
        }
    }

    private val viewContactLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            val posicion = data?.getIntExtra("posicion", -1) ?: -1
            val nombre = data?.getStringExtra("nombre") ?: ""
            val telefono = data?.getStringExtra("telefono") ?: ""
            val email = data?.getStringExtra("email") ?: ""
            if (posicion != -1 && nombre.isNotEmpty()) {
                listaContactos[posicion] = Contacto(nombre, telefono, email)
                adapter.notifyDataSetChanged()
            }
        }
    }

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
            val intent = Intent(this, AddContact::class.java)
            addContactLauncher.launch(intent)
        }

        listView.setOnItemClickListener { _, _, position, _ ->
            val contacto = listaContactos[position]
            val intent = Intent(this, ViewContact::class.java).apply {
                putExtra("posicion", position)
                putExtra("nombre", contacto.nombre)
                putExtra("telefono", contacto.telefono)
                putExtra("email", contacto.email)
            }
            viewContactLauncher.launch(intent)
        }
    }
}
