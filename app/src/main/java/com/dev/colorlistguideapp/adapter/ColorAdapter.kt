package com.dev.colorlistguideapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView
import com.dev.colorlistguideapp.R
import com.dev.colorlistguideapp.models.ColorData
import com.dev.colorlistguideapp.utils.SortType
import com.dev.colorlistguideapp.viewModel.ColorFavoriteViewModel
import kotlinx.android.synthetic.main.item_row.view.*
import java.util.*
import java.util.stream.Collectors
import kotlin.Comparator

class ColorAdapter(
    private var list: MutableList<ColorData>,
    private val viewModel: ColorFavoriteViewModel,
    private val isCanFav: Boolean
) : RecyclerView.Adapter<ColorAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName: TextView = itemView.txt_name
        val txtColor: TextView = itemView.txt_color
        val txtYear: TextView = itemView.txt_year
        val txtPantone: TextView = itemView.txt_pantone
        val btnFavorite: ToggleButton = itemView.btn_fav
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.txtName.text = item.name
        holder.txtColor.text = item.color
        holder.txtYear.text = item.year.toString()
        holder.txtPantone.text = item.pantone_value

        holder.btnFavorite.visibility = if (isCanFav) View.VISIBLE else View.GONE

        holder.btnFavorite.setOnClickListener {
            item.is_favorite = !item.is_favorite
            viewModel.setColorData(list)
        }

        holder.btnFavorite.isChecked = item.is_favorite
    }

    fun removeAt(position: Int) {
        list[position].is_favorite = false
        list.removeAt(position)
        notifyItemRemoved(position)
    }

    fun sortData(type: SortType) {
        when (type) {
            SortType.ASC -> Collections.sort(list, AscCompare())
            else -> Collections.sort(list, DescCompare())
        }
        notifyDataSetChanged()
    }

    internal class AscCompare : Comparator<ColorData> {
        override fun compare(p0: ColorData?, p1: ColorData?): Int =
            p0?.year?.compareTo(p1?.year!!)!!
    }

    internal class DescCompare : Comparator<ColorData> {
        override fun compare(p0: ColorData?, p1: ColorData?): Int =
            p1?.year?.compareTo(p0?.year!!)!!
    }

}