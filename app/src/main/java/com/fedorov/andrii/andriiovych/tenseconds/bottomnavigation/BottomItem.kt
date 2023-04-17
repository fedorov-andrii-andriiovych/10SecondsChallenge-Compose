package com.fedorov.andrii.andriiovych.tenseconds.bottomnavigation

import com.fedorov.andrii.andriiovych.tenseconds.R

sealed class BottomItem(
    val title: String,
    val iconId: Int,
    val route: String
) {
    object Screen1 : BottomItem("Screen 1", R.drawable.ten_secconds, "screen_1")
    object Screen2 : BottomItem("Screen 2", R.drawable.rating, "screen_2")
    object Screen3 : BottomItem("Screen 3", R.drawable.settings, "screen_3")
}
