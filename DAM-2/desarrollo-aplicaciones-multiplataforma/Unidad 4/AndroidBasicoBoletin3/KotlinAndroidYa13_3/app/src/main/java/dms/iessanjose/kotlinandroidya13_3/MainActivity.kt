package dms.iessanjose.kotlinandroidya13_3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preferencias = getSharedPreferences("datosUsuario", MODE_PRIVATE)
        val campoPuntuacion = findViewById<TextView>(R.id.tv2)
        campoPuntuacion.text = preferencias.getString("PuntuacionUsuario", "0")

        var numSecreto = (1..50).random()
        val campoRespuesta = findViewById<EditText>(R.id.et1)
        val pista = findViewById<TextView>(R.id.tv3)
        pista.text = numSecreto.toString()

        val botonComprobar = findViewById<Button>(R.id.bt1)

        botonComprobar.setOnClickListener {
            var puntuacion = campoPuntuacion.text.toString().toInt()
            val respuestaUsuario = campoRespuesta.text.toString().toInt()

            when {
                numSecreto > respuestaUsuario -> {
                    Toast.makeText(
                        this,
                        "El numero secreto es mayor, siga intentado",
                        Toast.LENGTH_SHORT
                    ).show()
                    campoRespuesta.text.clear()
                }

                numSecreto < respuestaUsuario -> {
                    Toast.makeText(
                        this,
                        "El numero secreto es menor, siga intentado",
                        Toast.LENGTH_SHORT
                    ).show()
                    campoRespuesta.text.clear()
                }

                else -> {
                    Toast.makeText(
                        this,
                        "Ha adivinado el numero secreto: $numSecreto",
                        Toast.LENGTH_SHORT
                    ).show()

                    puntuacion++
                    preferencias.edit(commit = true) {
                        putString("PuntuacionUsuario", puntuacion.toString())
                    }
                    // Actualizo la pantalla con el valor nuevo una vez se ha aladido a la preferencias.
                    campoPuntuacion.text = puntuacion.toString()
                    numSecreto = (1..50).random()
                    pista.text = numSecreto.toString()
                    campoRespuesta.text.clear()
                }
            }
        }
    }
}