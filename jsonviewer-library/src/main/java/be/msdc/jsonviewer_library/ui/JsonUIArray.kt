package be.msdc.jsonviewer_library.ui

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import com.google.gson.JsonArray
import com.google.gson.JsonElement

@Composable
fun JsonUIArray(
    jsonArray: JsonArray,
    label: String?,
)   {
    JsonUICollection(element = jsonArray, label = label)    {
        jsonArray.forEachIndexed { index, jsonElement ->
            arrayItem(index, jsonElement)
        }
    }
}

private fun LazyListScope.arrayItem(index: Int, element: JsonElement) {
    item {
        JsonUIElement(
            label = "$index",
            element = element,
        )
    }
}