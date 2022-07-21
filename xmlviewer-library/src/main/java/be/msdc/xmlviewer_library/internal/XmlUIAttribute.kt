package be.msdc.xmlviewer_library.internal

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Square
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.font.FontStyle.Companion.Normal
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
import androidx.compose.ui.unit.dp
import be.msdc.xmlviewer_library.XmlColorScheme

@Composable
internal fun XmlUIAttribute(key: String, value: String, colorScheme: XmlColorScheme) {
    XmlUIAttrData(
        key = key,
        value = value,
        keyColor = colorScheme.nodeAttributeKeyText,
        valueColor = colorScheme.nodeAttributeValueText,
        isItalic = false,
    )
}

@Composable
internal fun XmlUIMetadata(key: String, value: String, colorScheme: XmlColorScheme) {
    XmlUIAttrData(
        key = "#$key",
        value = value,
        keyColor = colorScheme.nodeMetadataKeyText,
        valueColor = colorScheme.nodeMetadataValueText,
        isItalic = true,
    )
}

@Composable
private fun XmlUIAttrData(key: String, value: String, keyColor: Color, valueColor: Color, isItalic: Boolean = false) {
    Row(
        modifier = Modifier
            .height(ROW_HEIGHT)
            .fillMaxWidth()
            .paddingXml(false),
        verticalAlignment = Alignment.Top
    ) {
        Text(
            text = "${key}: ",
            color = keyColor,
            fontStyle = if (isItalic) Italic else Normal
        )
        parseColor(value)?.let {
            Icon(
                Icons.Filled.Square,
                modifier = Modifier
                    .padding(top = 2.dp, end = 4.dp)
                    .size(16.dp),
                contentDescription = "Color $value",
                tint = it
            )
        }
        Text(
            text = value,
            color = valueColor,
            maxLines = 1,
            overflow = Ellipsis,
            fontStyle = if (isItalic) Italic else Normal
        )
    }
}