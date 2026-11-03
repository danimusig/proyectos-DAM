package dms.iessanjose.agendadecontactos

import android.content.ContentValues
import android.content.Intent
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

        val bundle = intent.extras
        val dato = bundle?.get
        val campoNombre = findViewById<EditText>(R.id.etAddNombre)
        val campoTelefono = findViewById<EditText>(R.id.etAddPhone)
        val campoEmail = findViewById<EditText>(R.id.etAddEmail)
        val botonAnyadir = findViewById<Button>(R.id.btAdd)

        botonAnyadir.setOnClickListener {
            val intento1 = Intent(this, MainActivity::class.java)
            intento1.putExtra("direccion", et1.text.toString())
            startActivity(intento1)

            val admin = AdminSQLiteOpenHelper(this, "agendaContactos", null, 1)
            val bd = admin.writableDatabase
            val registroContacto = ContentValues()
            registroContacto.put("telefono", campoTelefono.text.toString())
            registroContacto.put("nombre", campoNombre.text.toString())
            registroContacto.put("correo", campoEmail.text.toString())
            bd.insert("Contactos", null, registroContacto)
            bd.close()
            Toast.makeText(this, "Contacto añadido correctamente", Toast.LENGTH_SHORT).show()

        }
    }
}