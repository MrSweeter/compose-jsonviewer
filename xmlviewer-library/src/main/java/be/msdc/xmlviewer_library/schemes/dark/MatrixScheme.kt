package be.msdc.xmlviewer_library.schemes.dark

import androidx.compose.ui.graphics.Color
import be.msdc.xmlviewer_library.XmlColorScheme

fun DarkScheme.matrix(
    background: Color = Color(0xFF0C0C0C),
    rootIcon: Color = Color(0xffe37933),
    collapseIcon: Color = Color(0xff006600),
    nodeNameText: Color = Color(0xff88ff88),
    nodeInnerText: Color = Color(0xff00cc00),
    nodeAttributeKeyText: Color = Color(0xff00cc00),
    nodeAttributeValueText: Color = Color(0xff88ff88),
) = XmlColorScheme(
    background = background,
    rootIcon = rootIcon,
    collapseIcon = collapseIcon,
    nodeNameText = nodeNameText,
    nodeInnerText = nodeInnerText,
    nodeAttributeKeyText = nodeAttributeKeyText,
    nodeAttributeValueText = nodeAttributeValueText,
)