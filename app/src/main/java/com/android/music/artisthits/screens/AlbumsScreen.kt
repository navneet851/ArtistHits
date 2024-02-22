package com.android.music.artisthits.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.music.artisthits.viewmodels.SingersViewModel
import androidx.compose.material3.Text as Text

@Composable
fun AlbumsScreen() {
    val singersViewModel : SingersViewModel = viewModel()
    val singer = singersViewModel.singers.collectAsState()
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),

        ){
        items(singer.value.distinct()){
            SingerListItem(singer = it)
        }
    }
}

@Composable
fun SingerListItem(singer : String){
    Box(modifier = Modifier
        .padding(10.dp)
        .background(Color.LightGray)
        .border(1.dp, Color.Black, shape = RectangleShape)
        .padding(0.dp, 60.dp)
        .clip(RoundedCornerShape(50.dp)),
        contentAlignment = Alignment.Center
    ){
        Text(text = singer,
            fontSize = 15.sp)
    }
}