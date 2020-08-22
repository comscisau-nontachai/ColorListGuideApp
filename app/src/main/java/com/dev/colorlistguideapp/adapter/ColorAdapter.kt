package com.dev.colorlistguideapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView
import com.dev.colorlistguideapp.R
import com.dev.colorlistguideapp.models.ColorData
import com.dev.colorlistguideapp.viewModel.ColorFavoriteViewModel
import kotlinx.android.synthetic.main.item_row.view.*

class ColorAdapter(private var list : MutableList<ColorData>,private val viewModel: ColorFavoriteViewModel) : RecyclerView.Adapter<ColorAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName : TextView = itemView.txt_name
        val txtColor : TextView = itemView.txt_color
        val txtYear : TextView = itemView.txt_year
        val txtPantone : TextView = itemView.txt_pantone
        val btnFavorite : ToggleButton = itemView.btn_fav
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.txtName.text = item.name
        holder.txtColor.text = item.color
        holder.txtYear.text = item.year.toString()
        holder.txtPantone.text = item.pantone_value

        holder.btnFavorite.setOnClickListener {
            item.is_favorite = !item.is_favorite
            viewModel.setColorData(list)
        }

        holder.btnFavorite.isChecked = item.is_favorite
    }
}