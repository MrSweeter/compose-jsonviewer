package be.msdc.jsonviewer_library.internal

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import be.msdc.jsonviewer_library.JsonColorScheme
import com.google.gson.JsonArray
import com.google.gson.JsonElement

@Composable
internal fun JsonUIArray(
    jsonArray: JsonArray,
    label: String?,
    colorScheme: JsonColorScheme
) {
    JsonUICollection(element = jsonArray, label = label, colorScheme = colorScheme) {
        jsonArray.forEachIndexed { index, jsonElement ->
            arrayItem(index, jsonElement, colorScheme)
        }
    }
}

private fun LazyListScope.arrayItem(index: Int, element: JsonElement, colorScheme: JsonColorScheme) {
    item {
        JsonUIElement(
            label = "$index",
            element = element,
            colorScheme = colorScheme
        )
    }
}