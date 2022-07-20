package be.msdc.jsonviewer_library.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
import be.msdc.jsonviewer_library.ui.theme.JsonViewer
import be.msdc.jsonviewer_library.utils.ROW_HEIGHT
import be.msdc.jsonviewer_library.utils.paddingJson
import com.google.gson.JsonPrimitive

@Composable
fun JsonUINull(label: String?) {
    JsonUIString(value = "null", label = label, JsonViewer.colorScheme.primitiveNullText)
}

@Composable
fun JsonUIPrimitive(primitive: JsonPrimitive, label: String?) {
    val color = when    {
        primitive.isBoolean && primitive.asBoolean -> JsonViewer.colorScheme.primitiveBooleanTrueText
        primitive.isBoolean && !primitive.asBoolean -> JsonViewer.colorScheme.primitiveBooleanFalseText
        primitive.isNumber -> JsonViewer.colorScheme.primitiveNumberText
        primitive.isString -> JsonViewer.colorScheme.primitiveStringText
        else -> JsonViewer.colorScheme.primitiveNullText
    }
    JsonUIString(value = primitive.toString(), label = label, color = color)
}

@Composable
fun JsonUIString(value: String, label: String?, color: Color) {
    Row(
        modifier = Modifier
            .height(ROW_HEIGHT)
            .paddingJson(false),
        verticalAlignment = Alignment.Top
    ) {
        Text(text = "${label ?: "primitive"}: ", color = JsonViewer.colorScheme.primitiveLabelText)
        Text(text = value, color = color, maxLines = 1, overflow = Ellipsis)
    }
}