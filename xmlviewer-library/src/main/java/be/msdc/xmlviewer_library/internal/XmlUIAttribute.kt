package be.msdc.xmlviewer_library.internal

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Square
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
import androidx.compose.ui.unit.dp
import be.msdc.xmlviewer_library.XmlColorScheme

@Composable
internal fun XmlUIAttribute(key: String, value: String, colorScheme: XmlColorScheme) {
    Row(
        modifier = Modifier
            .height(ROW_HEIGHT)
            .fillMaxWidth()
            .paddingXml(false),
        verticalAlignment = Alignment.Top
    ) {
        Text(text = "${key}: ", color = colorScheme.nodeAttributeKeyText)
        parseColor(value)?.let {
            Icon(
                Icons.Filled.Square,
                modifier = Modifier.padding(top = 2.dp, end = 4.dp).size(16.dp),
                contentDescription = "Color $value",
                tint = it
            )
        }
        Text(text = value, color = colorScheme.nodeAttributeValueText, maxLines = 1, overflow = Ellipsis)
    }
}