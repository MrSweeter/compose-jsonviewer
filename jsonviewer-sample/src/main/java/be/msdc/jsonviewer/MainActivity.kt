package be.msdc.jsonviewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import be.msdc.jsonviewer_library.ui.JsonRoot
import be.msdc.jsonviewer_library.ui.theme.JsonViewer
import be.msdc.jsonviewer_library.ui.theme.defaultColorScheme
import be.msdc.jsonviewer_library.utils.readJsonResource

class MainActivity : ComponentActivity() {

    private val jsonColorScheme = defaultColorScheme(
        background = Color.LightGray
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        JsonViewer.update(jsonColorScheme)

        setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                JsonRoot(LocalContext.current.readJsonResource(R.raw.sample))
            }
        }
    }
}