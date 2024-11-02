package com.example.viewpager1.utils

import com.example.vazifa.R
import com.example.viewpager1.models.User

object MyData {
    val list = ArrayList<User>()

    fun addUser() {
        list.add(User("Xush kelibsiz", R.drawable.img))
        list.add(User("Hikoyalr dunyosi", R.drawable.img_1))
        list.add(User("Kitob ortidan...", R.drawable.img_2))
        list.add(User("Bizga qoshilinng", R.drawable.img_3))

    }


}