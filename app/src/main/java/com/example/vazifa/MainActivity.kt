package com.example.vazifa

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.vazifa.adapters.MyUserAdapter
import com.example.vazifa.databinding.ActivityMainBinding
import com.example.viewpager1.utils.MyData
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var myUserAdapter: MyUserAdapter
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        MyData.addUser()

        myUserAdapter = MyUserAdapter(MyData.list)
        binding.viewPager.adapter = myUserAdapter
        binding.myTab.setupWithViewPager(binding.viewPager)
        loadTabLayout()

    }

    private fun loadTabLayout() {
        val tabCount = binding.myTab.tabCount
        for (i in 0 until tabCount) {
            val tabView = LayoutInflater.from(this).inflate(R.layout.item_tab_layout, null, false)
            val tab = binding.myTab.getTabAt(i)
            tab?.customView = tabView
            val imageView = tabView.findViewById<ImageView>(R.id.image_indicator)
            if (i == 0) {
                imageView.setImageResource(R.drawable.ic_circle)
            } else {
                imageView.setImageResource(R.drawable.ic_circle2)
            }
        }
        binding.myTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val costomView = tab?.customView
                val image = costomView?.findViewById<ImageView>(R.id.image_indicator)
                image?.setImageResource(R.drawable.ic_circle)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val costomView = tab?.customView
                val image = costomView?.findViewById<ImageView>(R.id.image_indicator)
                image?.setImageResource(R.drawable.ic_circle2)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }
        })
    }

}

