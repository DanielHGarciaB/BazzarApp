package com.example.bazzarapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.content.Intent
import androidx.appcompat.app.AlertDialog
import android.content.DialogInterface
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var edtUsername: EditText? = null
    private var edtPassword: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtUsername = findViewById(R.id.edtUsername)
        edtPassword = findViewById(R.id.edtPassword)
    }
    fun onLogin(botonLogin: android.view.View) {
        var username : String = edtUsername!!.text.toString()
        var password : String = edtPassword!!.text.toString()
        if (username == "lfa@email.com" && password == "1234"){
            Toast.makeText(applicationContext,"WElCOME",Toast.LENGTH_LONG).show()
        }
        else{
            val dialog = AlertDialog.Builder(this).setTitle("ERROR!")
                .setMessage("Invalid user or password").create().show()

        }
    }
    fun onRegister(botonRegister: android.view.View) {}
}