package be.msdc.xmlviewer_library.internal

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import be.msdc.xmlviewer_library.XmlElement

val ICON_SIZE = 24.dp
val TAB_SIZE = 24.dp
val ROW_HEIGHT = 32.dp

fun Modifier.xmlHeight(xml: XmlElement): Modifier {
    val count = xml.countElement() - 1
    return this.then(
        heightIn(0.dp, ROW_HEIGHT * count)
    )
}

private fun XmlElement.countElement(): Int {
    val childCount = this.children.sumOf { it.countElement() } + 1
    val attributeCount = this.attributes.entries.count()
    return childCount + attributeCount + 1
}

@Stable
fun Modifier.paddingXml(withIcon: Boolean) = this.then(
    padding(
        start = TAB_SIZE - (if (withIcon) ICON_SIZE else 0.dp),
        end = 8.dp,
    )
)