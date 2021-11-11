package com.example.bazzarapp

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var edtUsername: EditText? = null
    private var edtPassword: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        //Splash
        //setTheme(R.style.SplashScreen)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.main_toolbar))
        edtUsername = findViewById(R.id.edtUsername)
        edtPassword = findViewById(R.id.edtPassword)
    }
    fun onLogin(botonLogin: android.view.View) {
        val username : String = edtUsername!!.text.toString()
        val password : String = edtPassword!!.text.toString()
        if (username == "lfa@mail.com" && password == "1234"){
            Toast.makeText(applicationContext,"WELCOME",Toast.LENGTH_LONG).show()
            val intento = Intent(this,HomeActivity::class.java)
            startActivity(intento)
        }
        else{
            val dialog = AlertDialog.Builder(this).setTitle("ERROR!")
                .setMessage("Invalid user or password").create().show()
        }
    }
    fun onRegister(botonRegister: android.view.View) {}
    fun onRecycle(view: android.view.View) {}
}