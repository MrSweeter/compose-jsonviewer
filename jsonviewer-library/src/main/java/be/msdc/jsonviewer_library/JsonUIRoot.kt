package be.msdc.jsonviewer_library

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import be.msdc.jsonviewer_library.internal.JsonUIElement
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import org.json.JSONArray
import org.json.JSONObject

@Composable
fun JsonUIRoot(
    element: JsonElement?,
    modifier: Modifier = Modifier,
    colorScheme: JsonColorScheme = defaultColorScheme()
) {
    element?.let {
        Box(modifier = modifier.background(colorScheme.background)) {
            JsonUIElement(label = null, element = element, colorScheme = colorScheme)
        }
    } ?: Box(modifier = modifier.background(colorScheme.background)) {
        Text(text = "Invalid JSON")
    }
}

@Composable
fun JsonUIRoot(
    jsonObject: JSONObject,
    modifier: Modifier = Modifier,
    colorScheme: JsonColorScheme = defaultColorScheme()
) = JsonUIRoot(jsonString = jsonObject.toString(), modifier = modifier, colorScheme = colorScheme)

@Composable
fun JsonUIRoot(
    jsonArray: JSONArray,
    modifier: Modifier = Modifier,
    colorScheme: JsonColorScheme = defaultColorScheme()
) = JsonUIRoot(jsonString = jsonArray.toString(), modifier = modifier, colorScheme = colorScheme)

@Composable
fun JsonUIRoot(
    jsonString: String,
    modifier: Modifier = Modifier,
    colorScheme: JsonColorScheme = defaultColorScheme()
) = JsonUIRoot(element = JsonParser.parseString(jsonString), modifier = modifier, colorScheme = colorScheme)