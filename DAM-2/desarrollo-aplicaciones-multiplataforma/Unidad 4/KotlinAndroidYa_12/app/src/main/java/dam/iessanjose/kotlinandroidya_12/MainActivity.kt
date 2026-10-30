package dam.iessanjose.kotlinandroidya_12

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val et1 = findViewById<EditText>(R.id.et1)
        val boton1 = findViewById<Button>(R.id.bt1)

        boton1.setOnClickListener {
            val intento1 = Intent(this, Actividad2::class.java)
            intento1.putExtra("direccion", et1.text.toString())
            startActivity(intento1)
        }
    }
}