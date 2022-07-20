package be.msdc.jsonviewer_library.internal

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import be.msdc.jsonviewer_library.JsonColorScheme
import com.google.gson.JsonElement
import com.google.gson.JsonObject

@Composable
internal fun JsonUIObject(
    jsonObject: JsonObject,
    label: String?,
    colorScheme: JsonColorScheme
)   {
    JsonUICollection(element = jsonObject, label = label, colorScheme = colorScheme)   {
        jsonObject.entrySet().forEach {
            objectItem(it, colorScheme)
        }
    }
}

private fun LazyListScope.objectItem(entry: MutableMap.MutableEntry<String, JsonElement>, colorScheme: JsonColorScheme) {
    item {
        JsonUIElement(
            label = entry.key,
            element = entry.value,
            colorScheme = colorScheme
        )
    }
}