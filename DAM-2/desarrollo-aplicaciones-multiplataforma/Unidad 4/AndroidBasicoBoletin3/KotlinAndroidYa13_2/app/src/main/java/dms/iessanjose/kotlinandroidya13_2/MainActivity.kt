package dms.iessanjose.kotlinandroidya13_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.edit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val et1=findViewById<EditText>(R.id.et1)
        val et2=findViewById<EditText>(R.id.etml1)
        val preferencias = getSharedPreferences("agenda", MODE_PRIVATE)
        val boton1=findViewById<Button>(R.id.bt1)
        boton1.setOnClickListener{
            preferencias.edit(commit = true) {
                putString(et1.text.toString(), et2.text.toString())
            }
            Toast.makeText(this, "Datos grabados", Toast.LENGTH_LONG).show()
            et1.setText("")
            et2.setText("")
        }
        val boton2=findViewById<Button>(R.id.bt2)
        boton2.setOnClickListener {
            val datos = preferencias.getString(et1.text.toString(), "")
            if (datos != null) {
                if (datos.isEmpty())
                    Toast.makeText(this, "No existe dicho nombre en la agenda", Toast.LENGTH_LONG).show()
                else
                    et2.setText(datos)
            }
        }
    }
}