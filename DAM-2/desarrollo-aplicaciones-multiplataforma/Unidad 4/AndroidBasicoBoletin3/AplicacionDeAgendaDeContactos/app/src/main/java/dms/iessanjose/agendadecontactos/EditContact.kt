package dms.iessanjose.agendadecontactos

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EditContact : AppCompatActivity() {
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

        val posicion = intent.getIntExtra("posicion", -1)
        val nombre = intent.getStringExtra("nombre") ?: ""
        val telefono = intent.getStringExtra("telefono") ?: ""
        val email = intent.getStringExtra("email") ?: ""

        campoNombre.setText(nombre)
        campoTelefono.setText(telefono)
        campoEmail.setText(email)

        botonGuardar.setOnClickListener {
            val resultIntent = Intent().apply {
                putExtra("posicion", posicion)
                putExtra("nombre", campoNombre.text.toString())
                putExtra("telefono", campoTelefono.text.toString())
                putExtra("email", campoEmail.text.toString())
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }

        botonVolver.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}