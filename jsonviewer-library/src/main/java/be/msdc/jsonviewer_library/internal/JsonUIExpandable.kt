package be.msdc.jsonviewer_library.internal

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.outlined.AccountTree
import androidx.compose.material.icons.outlined.DataArray
import androidx.compose.material.icons.outlined.DataObject
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import be.msdc.jsonviewer_library.JsonColorScheme
import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject

@Composable
internal fun JsonUIExpandable(
    label: String?,
    element: JsonElement,
    rotation: Float,
    colorScheme: JsonColorScheme,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .clickable { onClick() }
            .height(ROW_HEIGHT)
            .fillMaxWidth()
            .paddingJson(true),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (label == null) {
            val icon = when {
                element.isJsonArray -> Icons.Outlined.DataArray
                element.isJsonObject -> Icons.Outlined.DataObject
                else -> Icons.Outlined.AccountTree
            }
            Icon(
                icon,
                modifier = Modifier.size(ICON_SIZE),
                contentDescription = "json_element_root",
                tint = colorScheme.rootIcon
            )
        }
        Icon(
            Icons.Filled.ArrowDropDown,
            modifier = Modifier
                .rotate(rotation)
                .size(ICON_SIZE),
            contentDescription = "json_element_expandable",
            tint = colorScheme.dropArrowIcon
        )
        JsonUIElementText(label = label, element = element, colorScheme = colorScheme)
    }
}

@Composable
private fun JsonUIElementText(label: String?, element: JsonElement, colorScheme: JsonColorScheme) {
    when {
        element.isJsonObject -> JsonObjectText(
            jsonObject = element.asJsonObject,
            label = label,
            colorScheme = colorScheme
        )
        element.isJsonArray -> JsonArrayText(jsonArray = element.asJsonArray, label = label, colorScheme = colorScheme)
        else -> Text(text = "Invalid expandable item")
    }
}

@Composable
private fun JsonObjectText(jsonObject: JsonObject, label: String?, colorScheme: JsonColorScheme) {
    return SpannableItem(type = label ?: "object", count = "{${jsonObject.entrySet().size}}", colorScheme = colorScheme)
}

@Composable
private fun JsonArrayText(jsonArray: JsonArray, label: String?, colorScheme: JsonColorScheme) {
    return SpannableItem(type = label ?: "array", count = "[${jsonArray.size()}]", colorScheme = colorScheme)
}

@Composable
private fun SpannableItem(type: String, count: String, colorScheme: JsonColorScheme) {
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(colorScheme.collectionLabelText)) {
            append(type)
        }
        append(" ")
        withStyle(style = SpanStyle(colorScheme.collectionCounterText)) {
            append(count)
        }
    }
    Text(text = annotatedString)
}


