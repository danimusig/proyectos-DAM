package dam.iessanjose.a20261028androidbasicoboletin2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val campoUsuario = findViewById<EditText>(R.id.etUsuario)
        val campoPasswd = findViewById<EditText>(R.id.etPasswd)
        val botonAcceder = findViewById<Button>(R.id.btAcceso)

        botonAcceder.setOnClickListener {
            val nombreUsuario = campoUsuario.text.toString().trim()
            val passwdUsuario = campoPasswd.text.toString().trim()

            val usuariosValidos = mapOf<String, String>(
                "betiko55" to "54321",
                "Joselito2006" to "Joselito2006",
                "martinezGomez" to "000099990000"
            )

            if (!usuariosValidos.keys.contains(nombreUsuario)) {
                Toast.makeText(this, "Error el usuario no se encuentra en la base de datos.", Toast.LENGTH_SHORT).show()
            } else {
                val passwd = usuariosValidos[nombreUsuario]

                when (passwd) {
                    passwdUsuario -> Toast.makeText(this, "Acceso garantizado.", Toast.LENGTH_SHORT).show()
                    null -> Toast.makeText(this, "Usuario no encontrado.", Toast.LENGTH_SHORT).show()
                    else -> Toast.makeText(this, "Error contraseña incorrecta.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

