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
import com.dev.colorlistguideapp.viewModel.ColorFavoriteViewModel
import kotlinx.android.synthetic.main.fragment_list_color.*

const val TAG = "LOG_TAG"

class ListColorFragment : Fragment() {

    lateinit var viewModel: ColorFavoriteViewModel
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
        return inflater.inflate(R.layout.fragment_list_color, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(ColorFavoriteViewModel::class.java)

        viewModel.getColorData().observe(viewLifecycleOwner, Observer { dataList ->
            colorAdapter = ColorAdapter(dataList, viewModel, true)
            recycler_view_list.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = colorAdapter
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.menu_asc -> {
            Toast.makeText(requireContext(), "ASC", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.menu_desc -> {
            Toast.makeText(requireContext(), "DESC", Toast.LENGTH_SHORT).show()
            true
        }
        else -> {
            Toast.makeText(requireContext(), "cancel", Toast.LENGTH_SHORT).show()
            false
        }
    }

}