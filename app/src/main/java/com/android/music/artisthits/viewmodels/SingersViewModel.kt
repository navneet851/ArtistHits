package com.android.music.artisthits.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.music.artisthits.repository.ArtistHitsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SingersViewModel @Inject constructor(private val repository: ArtistHitsRepository) : ViewModel(){

    val singers : StateFlow<List<String>>
        get() = repository.singers

    init {
        viewModelScope.launch{
            repository.getSingers()
        }
    }
}