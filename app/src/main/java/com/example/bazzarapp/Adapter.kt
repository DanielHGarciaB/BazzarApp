package com.example.bazzarapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

public class Adapter(private val dataSet: List<item>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    public class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_product, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var titleItems = holder.itemView.findViewById<TextView>(R.id.titleItem);
        titleItems.text = dataSet[position].title;

        var textItems = holder.itemView.findViewById<TextView>(R.id.textItem);
        textItems.text = dataSet[position].text;

    }

    override fun getItemCount() = dataSet.size



}