package be.msdc.jsonviewer_library.internal

import androidx.compose.runtime.Composable
import be.msdc.jsonviewer_library.JsonColorScheme
import com.google.gson.JsonElement

@Composable
internal fun JsonUIElement(label: String?, element: JsonElement, colorScheme: JsonColorScheme) {
    when {
        element.isJsonObject -> JsonUIObject(
            jsonObject = element.asJsonObject,
            label = label,
            colorScheme = colorScheme,
        )
        element.isJsonArray -> JsonUIArray(
            jsonArray = element.asJsonArray,
            label = label,
            colorScheme = colorScheme,
        )
        element.isJsonNull -> JsonUINull(
            label = label,
            colorScheme = colorScheme,
        )
        element.isJsonPrimitive -> JsonUIPrimitive(
            primitive = element.asJsonPrimitive,
            label = label,
            colorScheme = colorScheme,
        )
    }
}