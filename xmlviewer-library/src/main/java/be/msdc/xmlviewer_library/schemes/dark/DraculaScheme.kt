package be.msdc.xmlviewer_library.schemes.dark

import androidx.compose.ui.graphics.Color
import be.msdc.xmlviewer_library.XmlColorScheme

fun DarkScheme.dracula(
    background: Color = Color(0xFF282A36),
    rootIcon: Color = Color(0xffe37933),
    collapseIcon: Color = Color(0xff6272a4),
    nodeNameText: Color = Color(0xffff79c6),
    nodeInnerText: Color = Color(0xfff8f8f2),
    nodeAttributeKeyText: Color = Color(0xff50fa7b),
    nodeAttributeValueText: Color = Color(0xfff1fa8c),
) = XmlColorScheme(
    background = background,
    rootIcon = rootIcon,
    collapseIcon = collapseIcon,
    nodeNameText = nodeNameText,
    nodeInnerText = nodeInnerText,
    nodeAttributeKeyText = nodeAttributeKeyText,
    nodeAttributeValueText = nodeAttributeValueText,
)