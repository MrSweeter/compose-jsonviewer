package be.msdc.xmlviewer_library.internal

import androidx.compose.runtime.Composable
import be.msdc.xmlviewer_library.XmlColorScheme
import be.msdc.xmlviewer_library.XmlElement

@Composable
internal fun XmlUIElement(element: XmlElement, colorScheme: XmlColorScheme) {
    when    {
        element.children.isNotEmpty() || element.attributes.isNotEmpty() -> XmlUICollection(
            element = element,
            colorScheme = colorScheme,
        )
        else -> XmlUIEmpty(element = element, colorScheme = colorScheme)
    }
}