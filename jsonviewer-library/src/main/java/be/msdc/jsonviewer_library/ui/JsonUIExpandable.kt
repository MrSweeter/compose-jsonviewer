package be.msdc.jsonviewer_library.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import be.msdc.jsonviewer_library.ui.theme.JsonViewer
import be.msdc.jsonviewer_library.utils.ICON_SIZE
import be.msdc.jsonviewer_library.utils.ROW_HEIGHT
import be.msdc.jsonviewer_library.utils.paddingJson
import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject

@Composable
fun JsonUIExpandable(
    label: String?,
    element: JsonElement,
    rotation: Float,
    onClick: () -> Unit,
)   {
    Row(
        modifier = Modifier
            .clickable { onClick() }
            .height(ROW_HEIGHT)
            .paddingJson(true),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(Icons.Filled.ArrowDropDown,
            modifier = Modifier.rotate(rotation).size(ICON_SIZE),
            contentDescription = "json_element_expandable",
            tint = JsonViewer.colorScheme.dropArrowIcon
        )
        JsonUIElementText(label = label, element = element)
    }
}

@Composable
fun JsonUIElementText(label: String?, element: JsonElement) {
    when  {
        element.isJsonObject -> JsonObjectText(jsonObject = element.asJsonObject, label = label)
        element.isJsonArray -> JsonArrayText(jsonArray = element.asJsonArray, label = label)
        else -> Text(text = "Invalid expandable item")
    }
}

@Composable
fun JsonObjectText(jsonObject: JsonObject, label: String?) {
    return SpannableItem(type = label ?: "object", count = "{${jsonObject.entrySet().size}}")
}

@Composable
fun JsonArrayText(jsonArray: JsonArray, label: String?) {
    return SpannableItem(type = label ?: "array", count = "[${jsonArray.size()}]")
}

@Composable
fun SpannableItem(type: String, count: String)  {
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(JsonViewer.colorScheme.collectionLabelText))    {
            append(type)
        }
        append(" ")
        withStyle(style = SpanStyle(JsonViewer.colorScheme.collectionCounterText)) {
            append(count)
        }
    }
    Text(text = annotatedString)
}


