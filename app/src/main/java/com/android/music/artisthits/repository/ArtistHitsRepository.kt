package com.android.music.artisthits.repository

import androidx.compose.runtime.MutableState
import com.android.music.artisthits.api.ArtistHitsApi
import com.android.music.artisthits.models.AlbumsListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ArtistHitsRepository @Inject constructor(private val artistHitsApi: ArtistHitsApi) {

    private val _albums = MutableStateFlow<List<AlbumsListItem>>(emptyList())
    val albums : StateFlow<List<AlbumsListItem>>
        get() = _albums

    private val _singers = MutableStateFlow<List<String>>(emptyList())
    val singers : StateFlow<List<String>>
        get() = _singers

    suspend fun getHits(singer : String){
        val response = artistHitsApi.getHits("albums[?(@.singer==\"$singer\")]")
        if(response.isSuccessful && response.body() != null){
            _albums.emit(response.body()!!)
        }
    }
    suspend fun getSingers(){
        val response = artistHitsApi.getSingers()
        if(response.isSuccessful && response.body() != null){
            _singers.emit(response.body()!!)
        }
    }
}