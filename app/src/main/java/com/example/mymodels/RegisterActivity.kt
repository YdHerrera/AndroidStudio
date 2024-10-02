package com.example.mymodels

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView



class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


//para ir al home desde regitsrar
        val button3Button = findViewById<Button>(R.id.button3)

        button3Button.setOnClickListener {
            // Crear un Intent para iniciar la RegisterActivity
            val intent = Intent(this,  HomeActivity::class.java)
            startActivity(intent) }



        //para devolverse al login
         val GoLogin = findViewById<TextView>(R.id.GoLogin)
        GoLogin.setOnClickListener{
            GoLogin()

        }
    }
    private fun GoLogin(){
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)


    }



}