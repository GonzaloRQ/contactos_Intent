package com.gramirez.contactos
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalleContactoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalle_contacto)

        val nombreTextView = findViewById<TextView>(R.id.nombreTextView)
        val emailTextView = findViewById<TextView>(R.id.emailTextView)
        val telefonoTextView = findViewById<TextView>(R.id.telefonoTextView)
        val emailButton = findViewById<Button>(R.id.emailButton)
        val llamarButton = findViewById<Button>(R.id.llamarButton)

        val nombre = intent.getStringExtra("nombre")
        val email = intent.getStringExtra("email")
        val telefono = intent.getStringExtra("telefono")

        nombreTextView.text = nombre
        emailTextView.text = email
        telefonoTextView.text = telefono

        emailButton.setOnClickListener {
            val destinatario = intent.getStringExtra("email")
            val emailIntent = Intent(Intent.ACTION_SENDTO)
            emailIntent.data = Uri.parse("mailto:$destinatario")
            emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(destinatario))
            emailIntent.setPackage("com.google.android.gm") // Especifica que deseas usar Gmail
            startActivity(emailIntent)
        }







        llamarButton.setOnClickListener {
            // Acción para realizar una llamada
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:$telefono")
            startActivity(callIntent)
        }
    }
}