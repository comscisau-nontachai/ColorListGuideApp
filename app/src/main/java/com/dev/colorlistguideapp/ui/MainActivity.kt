package com.dev.colorlistguideapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.dev.colorlistguideapp.R
import com.dev.colorlistguideapp.adapter.ViewPagerAdapter
import com.dev.colorlistguideapp.viewModel.ColorFavoriteViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: ViewPagerAdapter
    lateinit var viewModel: ColorFavoriteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(ColorFavoriteViewModel::class.java)

        initViewPager()

        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                when(position) {
                    0 -> viewModel.isNotify.postValue(true)
                }
            }

        })

    }

    private fun initViewPager() {
        adapter = ViewPagerAdapter(this, supportFragmentManager)
        view_pager.adapter = adapter
        tabs_main.setupWithViewPager(view_pager)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item,menu)
        return true
    }
}