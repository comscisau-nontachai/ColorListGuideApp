package com.dev.colorlistguideapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.colorlistguideapp.R
import com.dev.colorlistguideapp.adapter.ColorAdapter
import com.dev.colorlistguideapp.utils.SortType
import com.dev.colorlistguideapp.viewModel.ColorFavoriteViewModel
import kotlinx.android.synthetic.main.fragment_list_color_fav.*

class ListColorFavFragment : Fragment() {

    lateinit var colorAdapter: ColorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_color_fav, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(requireActivity()).get(ColorFavoriteViewModel::class.java)

        viewModel.listColor.observe(viewLifecycleOwner, Observer { listData ->
            Log.d(TAG, "onViewCreated: ${listData.filter { it.is_favorite }}")

            colorAdapter =
                ColorAdapter(listData.filter { it.is_favorite }.toMutableList(), viewModel, false)
            recycler_view_list_fav.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = colorAdapter
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.menu_asc -> {
            Toast.makeText(requireContext(), "ASC", Toast.LENGTH_SHORT).show()
            colorAdapter.sortData(SortType.ASC)
            true
        }
        R.id.menu_desc -> {
            Toast.makeText(requireContext(), "DESC", Toast.LENGTH_SHORT).show()
            colorAdapter.sortData(SortType.DESC)
            true
        }
        else -> {
            false
        }
    }
}