package dms.iessanjose.kotlinandroidya13_1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val et1=findViewById<EditText>(R.id.etmail1)
        val preferencias = getSharedPreferences("datos", MODE_PRIVATE)
        et1.setText(preferencias.getString("mail", ""))
        val boton1=findViewById<Button>(R.id.bt1)
        boton1.setOnClickListener {
            val editor = preferencias.edit()
            editor.putString("mail", et1.text.toString())
            editor.commit()
            finish()
        }
    }
}