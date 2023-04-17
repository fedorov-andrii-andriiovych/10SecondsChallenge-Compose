package com.fedorov.andrii.andriiovych.tenseconds.bottomnavigation

import com.fedorov.andrii.andriiovych.tenseconds.R

sealed class BottomItem(
    val title: String,
    val iconId: Int,
    val route: String
) {
    object Screen1 : BottomItem("Game", R.drawable.ten_secconds, SCREEN_MAIN)
    object Screen2 : BottomItem("Rating", R.drawable.rating, SCREEN_RATING)
    object Screen3 : BottomItem("Settings", R.drawable.settings, SCREEN_SETTINGS)

    companion object {
       const val SCREEN_MAIN= "screenMain"
       const val SCREEN_RATING= "screenRating"
       const val SCREEN_SETTINGS= "screenSettings"
    }
}


