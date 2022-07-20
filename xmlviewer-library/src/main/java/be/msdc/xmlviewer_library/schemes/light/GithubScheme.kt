package be.msdc.xmlviewer_library.schemes.light

import androidx.compose.ui.graphics.Color
import be.msdc.xmlviewer_library.XmlColorScheme

fun LightScheme.github(
    background: Color = Color(0xffffffff),
    rootIcon: Color = Color(0xffcc6d2e),
    collapseIcon: Color = Color(0xffbabbbc),
    nodeNameText: Color = Color(0xff22863a),
    nodeInnerText: Color = Color(0xff000000),
    nodeAttributeKeyText: Color = Color(0xff6f42c1),
    nodeAttributeValueText: Color = Color(0xff032f62),
) = XmlColorScheme(
    background = background,
    rootIcon = rootIcon,
    collapseIcon = collapseIcon,
    nodeNameText = nodeNameText,
    nodeInnerText = nodeInnerText,
    nodeAttributeKeyText = nodeAttributeKeyText,
    nodeAttributeValueText = nodeAttributeValueText,
)