package dms.iessanjose.agendadecontactos

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ViewContact : AppCompatActivity() {

    private var posicion = -1
    private var nombre = ""
    private var telefono = ""
    private var email = ""

    private val editContactLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            posicion = data?.getIntExtra("posicion", -1) ?: -1
            nombre = data?.getStringExtra("nombre") ?: ""
            telefono = data?.getStringExtra("telefono") ?: ""
            email = data?.getStringExtra("email") ?: ""

            findViewById<TextView>(R.id.tvTitleNombre).text = nombre
            findViewById<TextView>(R.id.tvViewName).text = nombre
            findViewById<TextView>(R.id.tvViewPhone).text = telefono
            findViewById<TextView>(R.id.etViewEmail).text = email

            val resultIntent = Intent().apply {
                putExtra("posicion", posicion)
                putExtra("nombre", nombre)
                putExtra("telefono", telefono)
                putExtra("email", email)
            }
            setResult(Activity.RESULT_OK, resultIntent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_contact)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvTitle = findViewById<TextView>(R.id.tvTitleNombre)
        val tvName = findViewById<TextView>(R.id.tvViewName)
        val tvPhone = findViewById<TextView>(R.id.tvViewPhone)
        val tvEmail = findViewById<TextView>(R.id.etViewEmail)
        val btVolver = findViewById<Button>(R.id.btAdd)
        val btEditar = findViewById<Button>(R.id.btEditar)

        posicion = intent.getIntExtra("posicion", -1)
        nombre = intent.getStringExtra("nombre") ?: ""
        telefono = intent.getStringExtra("telefono") ?: ""
        email = intent.getStringExtra("email") ?: ""

        tvTitle.text = nombre
        tvName.text = nombre
        tvPhone.text = telefono
        tvEmail.text = email

        btEditar.setOnClickListener {
            val intent = Intent(this, EditContact::class.java).apply {
                putExtra("posicion", posicion)
                putExtra("nombre", nombre)
                putExtra("telefono", telefono)
                putExtra("email", email)
            }
            editContactLauncher.launch(intent)
        }

        btVolver.setOnClickListener {
            finish()
        }
    }
}