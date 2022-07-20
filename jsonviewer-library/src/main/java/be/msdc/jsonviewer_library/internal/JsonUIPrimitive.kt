package be.msdc.jsonviewer_library.internal

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
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
        Text(text = value, color = color, maxLines = 1, overflow = Ellipsis)
    }
}