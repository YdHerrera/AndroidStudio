package com.example.mymodels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val registerButton = findViewById<Button>(R.id.register)

        registerButton.setOnClickListener {
            // Crear un Intent para iniciar la RegisterActivity
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent) }

        val ingresarButton = findViewById<Button>(R.id.ingresar)

        ingresarButton.setOnClickListener {
            // Crear un Intent para iniciar la RegisterActivity
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent) }


    }

}