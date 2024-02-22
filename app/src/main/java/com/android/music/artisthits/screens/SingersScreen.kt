package com.android.music.artisthits.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.music.artisthits.viewmodels.AlbumsViewModel
import com.android.music.artisthits.viewmodels.SingersViewModel

@Composable
fun SingersScreen() {
    val albumsViewModel : AlbumsViewModel = viewModel()
    val albums = albumsViewModel.albums.collectAsState()
    LazyColumn{
        items(albums.value){
            SingersAlbumList(albums = it.name)
        }
    }
}

@Composable
fun SingersAlbumList(albums : String) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
        .background(Color.Red)
        .padding(30.dp)) {
        Text(
            text = albums,
            color = Color.Black)
    }
}