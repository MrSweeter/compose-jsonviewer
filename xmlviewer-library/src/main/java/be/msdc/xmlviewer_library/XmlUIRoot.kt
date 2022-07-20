package be.msdc.xmlviewer_library

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import be.msdc.xmlviewer_library.internal.XmlUIElement

@Composable
fun XmlUIRoot(
    element: XmlElement?,
    modifier: Modifier = Modifier,
    colorScheme: XmlColorScheme = defaultColorScheme()
) {
    element?.let {
        Box(modifier = modifier.background(colorScheme.background)) {
            XmlUIElement(element = element, colorScheme = colorScheme)
        }
    } ?: Box(modifier = modifier.background(colorScheme.background)) {
        Text(text = "Invalid XML")
    }
}

@Composable
fun XmlUIRoot(xmlString: String, modifier: Modifier, colorScheme: XmlColorScheme = defaultColorScheme()) {
    XmlUIRoot(element = XmlParser.parseString(xmlString), modifier = modifier, colorScheme = colorScheme)
}