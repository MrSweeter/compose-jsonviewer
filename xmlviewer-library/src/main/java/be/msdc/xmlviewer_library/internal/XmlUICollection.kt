package be.msdc.xmlviewer_library.internal

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import be.msdc.xmlviewer_library.XmlColorScheme
import be.msdc.xmlviewer_library.XmlElement

@Composable
internal fun XmlUICollection(
    element: XmlElement,
    colorScheme: XmlColorScheme,
) {
    var expanded by remember { mutableStateOf(false) }
    val rotation by animateFloatAsState(targetValue = if (expanded) 0f else -90f)

    Column {
        XmlUIExpandable(
            element = element,
            rotation = rotation,
            colorScheme = colorScheme,
            onClick = { expanded = expanded.not() },
        )
        AnimatedVisibility(
            visible = expanded,
            modifier = Modifier.padding(start = TAB_SIZE)
        ) {
            LazyColumn(modifier = Modifier.xmlHeight(element)) {
                element.metadata.forEach {
                    metadataItem(it.key, it.value, colorScheme)
                }
                element.attributes.forEach {
                    attributeItem(it.key, it.value, colorScheme)
                }
                element.children.forEach {
                    objectItem(it, colorScheme)
                }
            }
        }
    }
}

private fun LazyListScope.metadataItem(key: String, value: String, colorScheme: XmlColorScheme) {
    item {
        XmlUIMetadata(
            key = key,
            value = value,
            colorScheme = colorScheme
        )
    }
}

private fun LazyListScope.attributeItem(key: String, value: String, colorScheme: XmlColorScheme) {
    item {
        XmlUIAttribute(
            key = key,
            value = value,
            colorScheme = colorScheme
        )
    }
}

private fun LazyListScope.objectItem(element: XmlElement, colorScheme: XmlColorScheme) {
    item {
        XmlUIElement(
            element = element,
            colorScheme = colorScheme
        )
    }
}
