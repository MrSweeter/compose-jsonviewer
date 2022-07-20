package be.msdc.xmlviewer_library

import androidx.compose.ui.graphics.Color

data class XmlColorScheme(
    val background: Color,
    val rootIcon: Color,
    val collapseIcon: Color,
    val nodeNameText: Color,
    val nodeInnerText: Color,
    val nodeAttributeKeyText: Color,
    val nodeAttributeValueText: Color,
)

fun defaultColorScheme(
    background: Color = Color.LightGray,
    rootIcon: Color = Color(0xFFBF360C),
    collapseIcon: Color = Color(0xFFBF360C),
    nodeNameText: Color = Color(0xFFBF360C),
    nodeInnerText: Color = Color.Black,
    nodeAttributeKeyText: Color = Color(0xFF2E7D32),
    nodeAttributeValueText: Color = Color(0xFF2E7D32),
): XmlColorScheme =
    XmlColorScheme(
        background = background,
        rootIcon = rootIcon,
        collapseIcon = collapseIcon,
        nodeNameText = nodeNameText,
        nodeInnerText = nodeInnerText,
        nodeAttributeKeyText = nodeAttributeKeyText,
        nodeAttributeValueText = nodeAttributeValueText,
    )