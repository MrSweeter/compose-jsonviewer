package be.msdc.xmlviewer_library.schemes.dark

import androidx.compose.ui.graphics.Color
import be.msdc.xmlviewer_library.XmlColorScheme

fun DarkScheme.darcula(
    background: Color = Color(0xFF242424),
    rootIcon: Color = Color(0xffe37933),
    collapseIcon: Color = Color(0xff858585),
    nodeNameText: Color = Color(0xffffc66d),
    nodeInnerText: Color = Color(0xffcccccc),
    nodeAttributeKeyText: Color = Color(0xffcccccc),
    nodeAttributeValueText: Color = Color(0xff6a8759),
) = XmlColorScheme(
    background = background,
    rootIcon = rootIcon,
    collapseIcon = collapseIcon,
    nodeNameText = nodeNameText,
    nodeInnerText = nodeInnerText,
    nodeAttributeKeyText = nodeAttributeKeyText,
    nodeAttributeValueText = nodeAttributeValueText,
)