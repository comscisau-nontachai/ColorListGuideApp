package com.dev.colorlistguideapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dev.colorlistguideapp.R
import com.dev.colorlistguideapp.models.ColorData
import com.dev.colorlistguideapp.viewModel.ColorFavoriteViewModel
import kotlinx.android.synthetic.main.item_row.view.*

class ColorAdapter(private var list : MutableList<ColorData>,private val viewModel: ColorFavoriteViewModel) : RecyclerView.Adapter<ColorAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: ColorData){
            itemView.txt_name.text = data.name
            itemView.txt_color.text = data.color
            itemView.txt_year.text = data.year.toString()
            itemView.txt_pantone.text = data.pantone_value
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }
}