package be.msdc.xmlviewer_library.internal

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
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
        Text(text = value, color = colorScheme.nodeAttributeValueText, maxLines = 1, overflow = Ellipsis)
    }
}