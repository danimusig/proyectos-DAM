package dms.iessanjose.agendadecontactos

import android.app.Activity
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
        val campoNombre = findViewById<EditText>(R.id.etAddNombre)
        val campoTelefono = findViewById<EditText>(R.id.etAddPhone)
        val campoEmail = findViewById<EditText>(R.id.etAddEmail)
        val botonVolver = findViewById<Button>(R.id.btAdd) // btAdd en el XML contiene "Volver"
        val botonAnyadir = findViewById<Button>(R.id.btBack) // btBack en el XML contiene "Añadir"

        botonAnyadir.setOnClickListener {
            val resultIntent = Intent().apply {
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