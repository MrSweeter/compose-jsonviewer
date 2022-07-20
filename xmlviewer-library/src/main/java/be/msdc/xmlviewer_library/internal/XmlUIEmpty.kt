package be.msdc.xmlviewer_library.internal

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CropSquare
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
import androidx.compose.ui.text.withStyle
import be.msdc.xmlviewer_library.XmlColorScheme
import be.msdc.xmlviewer_library.XmlElement

@Composable
internal fun XmlUIEmpty(
    element: XmlElement,
    colorScheme: XmlColorScheme,
)   {
    Row(
        modifier = Modifier
            .height(ROW_HEIGHT)
            .paddingXml(true),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(Icons.Outlined.CropSquare,
            modifier = Modifier.size(ICON_SIZE),
            contentDescription = "xml_element_empty",
            tint = colorScheme.collapseIcon
        )
        XmlUIElementText(element = element, colorScheme = colorScheme)
    }
}

@Composable
private fun XmlUIElementText(element: XmlElement, colorScheme: XmlColorScheme) {
    return SpannableItem(label = element.name, innerText = element.innerText.joinToString(" "), colorScheme = colorScheme)
}

@Composable
private fun SpannableItem(label: String, innerText: String, colorScheme: XmlColorScheme)  {
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = colorScheme.nodeNameText, fontWeight = FontWeight.ExtraBold))    {
            append(label)
        }
        append(" ")
        withStyle(style = SpanStyle(colorScheme.nodeInnerText)) {
            append(innerText.trim())
        }
    }
    Text(text = annotatedString, overflow = Ellipsis, maxLines = 1)
}


