package com.gramirez.contactos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.gramirez.contactos.databinding.ActivityMainBinding
import android.view.View


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = ContactosAdapter(contactos) { contacto ->
                val intent = Intent(this@MainActivity, DetalleContactoActivity::class.java)
                intent.putExtra("nombre", contacto.nombre)
                intent.putExtra("email", contacto.email)
                intent.putExtra("telefono", contacto.telefono)
                startActivity(intent)
            }



        }





    }

    private val contactos = (1..100).map{
        Contacto(
            "Nombre $it",
            "954$it$it$it$it$it$it",
            "email$it@gmail.com",
            "https://pbs.twimg.com/media/F6RmDfFXIAA2qsS.jpg"
        )
    }
}