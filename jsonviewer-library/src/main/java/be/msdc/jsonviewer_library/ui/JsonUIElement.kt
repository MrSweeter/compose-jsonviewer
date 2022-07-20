package be.msdc.jsonviewer_library.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import be.msdc.jsonviewer_library.ui.theme.JsonViewer
import com.google.gson.JsonElement

@Composable
fun JsonRoot(element: JsonElement)  {
    Box(modifier = Modifier.fillMaxSize().background(JsonViewer.colorScheme.background))    {
        JsonUIElement(label = null, element = element)
    }
}

@Composable
fun JsonUIElement(label: String?, element: JsonElement) {
    when    {
        element.isJsonObject -> JsonUIObject(
            jsonObject = element.asJsonObject,
            label = label
        )
        element.isJsonArray -> JsonUIArray(
            jsonArray = element.asJsonArray,
            label = label
        )
        element.isJsonNull -> JsonUINull(
            label = label
        )
        element.isJsonPrimitive -> JsonUIPrimitive(
            primitive = element.asJsonPrimitive,
            label = label
        )
    }
}