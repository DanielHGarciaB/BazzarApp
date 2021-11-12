package com.example.bazzarapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

class CatalogoActivity : AppCompatActivity() {

    var recycleView : RecyclerView? =null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo)

        recycleView = findViewById(R.id.reclycler);

        val list = listOf(
            item(R.drawable.chaqueta,"Chaqueta","Texto 1"),
            item(R.drawable.pantalon,"Pantalon","Texto 2"),
            item(R.drawable.tenis,"Tenis","Texto 3"));

        var adapter = Adapter(list);
        recycleView!!.setHasFixedSize(true);
        recycleView!!.adapter=adapter;
        recycleView!!.addItemDecoration(
            DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL)
        );

    }
}