package be.msdc.jsonviewer_library.ui

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import com.google.gson.JsonElement
import com.google.gson.JsonObject

@Composable
fun JsonUIObject(
    jsonObject: JsonObject,
    label: String?,
)   {
    JsonUICollection(element = jsonObject, label = label)   {
        jsonObject.entrySet().forEach {
            objectItem(it)
        }
    }
}

private fun LazyListScope.objectItem(entry: MutableMap.MutableEntry<String, JsonElement>) {
    item {
        JsonUIElement(
            label = entry.key,
            element = entry.value,
        )
    }
}