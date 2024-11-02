package com.example.vazifa.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.vazifa.databinding.ItemPageBinding
import com.example.viewpager1.models.User

class MyUserAdapter(var list: ArrayList<User>) : PagerAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemPageBinding =
            ItemPageBinding.inflate(LayoutInflater.from(container.context), container, false)
        itemPageBinding.imgPage.setImageResource(list[position].image)
        itemPageBinding.tvPage.text = list[position].name

        container.addView(itemPageBinding.root)

        return itemPageBinding.root

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }
}