package com.example.bazzarapp

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.facebook.CallbackManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class MainActivity : AppCompatActivity() {
    private var edtUsername: EditText? = null
    private var edtPassword: EditText? = null

    private val GOOGLE_SING_IN = 100
    private val callbackManager = CallbackManager.Factory.create()

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

        if (username.isNotEmpty() && password.isNotEmpty()) {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(username, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        showHome(username, ProviderType.BASIC)
                    } else {
                        getToast("Failed to authenticate");
                    }
                }

        } else {
            getToast("Invalid email or password");
        }

       /*
        if (username == "lfa@mail.com" && password == "1234"){
            Toast.makeText(applicationContext,"WELCOME",Toast.LENGTH_LONG).show()
            val intento = Intent(this,HomeActivity::class.java)
            startActivity(intento)
        }
        else{
            val dialog = AlertDialog.Builder(this).setTitle("ERROR!")
                .setMessage("Invalid user or password").create().show()
        }
        */
    }

    fun onRegister(botonRegister: android.view.View) {
            val registerIntent = Intent(this, RegisterActivity::class.java)
            startActivity(registerIntent)
    }
    fun onRecycle(view: android.view.View) {}

    private fun showHome(username: String, provider: ProviderType) {

        val homeIntent = Intent(this, HomeActivity::class.java).apply {
            putExtra("email", username)
            putExtra("provider", provider.toString())
        }

        startActivity(homeIntent)

        getToast("Welcome");
    }

    private fun getToast(message: String) {
        Toast.makeText(
            applicationContext,
            message,
            Toast.LENGTH_LONG
        ).show();
    }

    fun googleLogin(view: android.view.View) {

        val googleConf = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(resources.getString(R.string.default_web_client_id2))
            .requestEmail().build()

        val googleClient = GoogleSignIn.getClient(this, googleConf)
        googleClient.signOut()
        startActivityForResult(googleClient.signInIntent, GOOGLE_SING_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == GOOGLE_SING_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)

            try {
                val account = task.getResult(ApiException::class.java)
                if (account != null) {
                    val credencial = GoogleAuthProvider.getCredential(account.idToken, null)
                    FirebaseAuth.getInstance().signInWithCredential(credencial)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                showHome(account.email ?: "", ProviderType.GOOGLE)
                            } else {
                                getToast("Failed to authenticate");
                            }
                        }
                }
            } catch (e: ApiException) {
                getToast("Failed to authenticate");
            }
        }
    }
}