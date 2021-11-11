package com.example.bazzarapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(findViewById(R.id.toolbar))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                Toast.makeText(this,"Configuracion",Toast.LENGTH_LONG).show()
                true
            }
            R.id.menu_buscar -> {
                Toast.makeText(this,"Buscar",Toast.LENGTH_LONG).show()
                true
            }
            R.id.acercaDe -> {
                Toast.makeText(this,"Acerca de",Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun onRecycle(view: View){
        val intent = Intent(this,CatalogoActivity::class.java);
        startActivity(intent)
    }
}