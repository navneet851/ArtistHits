package com.android.music.artisthits.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.music.artisthits.models.AlbumsListItem
import com.android.music.artisthits.repository.ArtistHitsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumsViewModel @Inject constructor(private val repository: ArtistHitsRepository) : ViewModel(){

    val albums : StateFlow<List<AlbumsListItem>>
        get() = repository.albums

    init {
        viewModelScope.launch{
            repository.getHits("Karan Aujla")
        }
    }
}