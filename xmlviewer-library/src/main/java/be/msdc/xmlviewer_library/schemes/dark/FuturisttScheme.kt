package be.msdc.xmlviewer_library.schemes.dark

import androidx.compose.ui.graphics.Color
import be.msdc.xmlviewer_library.XmlColorScheme

fun DarkScheme.futuristt(
    background: Color = Color(0xff000000),
    rootIcon: Color = Color(0xffe37933),
    collapseIcon: Color = Color(0xff555555),
    nodeNameText: Color = Color(0xffeb0869),
    nodeInnerText: Color = Color(0xffffffff),
    nodeAttributeKeyText: Color = Color(0xfff3f359),
    nodeAttributeValueText: Color = Color(0xff32d698),
) = XmlColorScheme(
    background = background,
    rootIcon = rootIcon,
    collapseIcon = collapseIcon,
    nodeNameText = nodeNameText,
    nodeInnerText = nodeInnerText,
    nodeAttributeKeyText = nodeAttributeKeyText,
    nodeAttributeValueText = nodeAttributeValueText,
)