package com.example.novenasemana.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.novenasemana.R
import com.example.novenasemana.db.entity.AutoEntity
import kotlinx.android.synthetic.main.card_auto.view.*

class AutoAdapter (context: Context)
    :RecyclerView.Adapter<AutoAdapter.AutoViewHolder>(){

    var autos = emptyList<AutoEntity>()
    var inflater:LayoutInflater = LayoutInflater.from(context)

    override fun getItemCount() = autos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
        = AutoViewHolder(inflater.inflate(R.layout.card_auto,parent,false))

    override fun onBindViewHolder(holder: AutoViewHolder, position: Int)
            = holder.bind(autos[position])

    internal fun setAutos(cars:List<AutoEntity>){
        this.autos = cars
        notifyDataSetChanged()
    }
    class AutoViewHolder(item:View):RecyclerView.ViewHolder(item){
        fun bind(auto:AutoEntity) {
            itemView.apply {
                brand.text = auto.brand
                model.text = auto.model
                year.text = auto.year.toString()
            }
        }
    }
}