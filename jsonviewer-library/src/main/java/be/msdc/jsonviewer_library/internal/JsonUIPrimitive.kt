package be.msdc.jsonviewer_library.internal

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Square
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
import androidx.compose.ui.unit.dp
import be.msdc.jsonviewer_library.JsonColorScheme
import com.google.gson.JsonPrimitive

@Composable
internal fun JsonUINull(label: String?, colorScheme: JsonColorScheme) {
    JsonUIString(value = "null", label = label, colorScheme.primitiveNullText, colorScheme = colorScheme)
}

@Composable
internal fun JsonUIPrimitive(primitive: JsonPrimitive, label: String?, colorScheme: JsonColorScheme) {
    val color = when {
        primitive.isBoolean && primitive.asBoolean -> colorScheme.primitiveBooleanTrueText
        primitive.isBoolean && !primitive.asBoolean -> colorScheme.primitiveBooleanFalseText
        primitive.isNumber -> colorScheme.primitiveNumberText
        primitive.isString -> colorScheme.primitiveStringText
        else -> colorScheme.primitiveNullText
    }
    JsonUIString(value = primitive.toString(), label = label, color = color, colorScheme = colorScheme)
}

@Composable
private fun JsonUIString(value: String, label: String?, color: Color, colorScheme: JsonColorScheme) {
    Row(
        modifier = Modifier
            .height(ROW_HEIGHT)
            .fillMaxWidth()
            .paddingJson(false),
        verticalAlignment = Alignment.Top
    ) {
        Text(text = "${label ?: "primitive"}: ", color = colorScheme.primitiveLabelText)
        parseColor(value)?.let {
            Icon(
                Icons.Filled.Square,
                modifier = Modifier.padding(top = 2.dp, end = 4.dp).size(16.dp),
                contentDescription = "Color $value",
                tint = it
            )
        }
        Text(text = value, color = color, maxLines = 1, overflow = Ellipsis)
    }
}