package com.example.bazzarapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

class CatalogoActivity : AppCompatActivity() {

    var recycleView : RecyclerView? =null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo)

        recycleView = findViewById(R.id.reclycler);

        val list = listOf(
            item("@drawable/logo","Prueba 1","Texto 1"),
            item("@drawable/logo","Prueba 2","Texto 2"),
            item("@drawable/logo","Prueba 3","Texto 3"));

        var adapter = Adapter(list);
        recycleView!!.setHasFixedSize(true);
        recycleView!!.adapter=adapter;
        recycleView!!.addItemDecoration(
            DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL)
        );

    }
}