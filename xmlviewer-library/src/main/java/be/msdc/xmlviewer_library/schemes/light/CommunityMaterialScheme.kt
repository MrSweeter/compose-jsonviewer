package be.msdc.xmlviewer_library.schemes.light

import androidx.compose.ui.graphics.Color
import be.msdc.xmlviewer_library.XmlColorScheme

fun LightScheme.communityMaterial(
    background: Color = Color(0xffffffff),
    rootIcon: Color = Color(0xffcc6d2e),
    collapseIcon: Color = Color(0xff2f86d2),
    nodeNameText: Color = Color(0xffff5370),
    nodeInnerText: Color = Color(0xff90a4ae),
    nodeAttributeKeyText: Color = Color(0xff7c4dff),
    nodeAttributeValueText: Color = Color(0xff91b859),
) = XmlColorScheme(
    background = background,
    rootIcon = rootIcon,
    collapseIcon = collapseIcon,
    nodeNameText = nodeNameText,
    nodeInnerText = nodeInnerText,
    nodeAttributeKeyText = nodeAttributeKeyText,
    nodeAttributeValueText = nodeAttributeValueText,
)