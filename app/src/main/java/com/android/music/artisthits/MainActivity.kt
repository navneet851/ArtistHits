package com.android.music.artisthits

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.android.music.artisthits.api.ArtistHitsApi
import com.android.music.artisthits.screens.AlbumsScreen
import com.android.music.artisthits.screens.SingersScreen
import com.android.music.artisthits.ui.theme.ArtistHitsTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ArtistHitsTheme {
                // A surface container using the 'background' color from the theme
                SingersScreen()
            }
        }
    }
}

