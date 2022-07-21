package be.msdc.xmlviewer_library.schemes.dark

import androidx.compose.ui.graphics.Color
import be.msdc.xmlviewer_library.XmlColorScheme

fun DarkScheme.github(
    background: Color = Color(0xFF24292E),
    rootIcon: Color = Color(0xffe37933),
    collapseIcon: Color = Color(0xff444d56),
    nodeNameText: Color = Color(0xff85e89d),
    nodeInnerText: Color = Color(0xffe1e4e8),
    nodeMetadataKeyText: Color = Color(0xffb392f0),
    nodeMetadataValueText: Color = Color(0xff9ecbff),
    nodeAttributeKeyText: Color = Color(0xffb392f0),
    nodeAttributeValueText: Color = Color(0xff9ecbff),
) = XmlColorScheme(
    background = background,
    rootIcon = rootIcon,
    collapseIcon = collapseIcon,
    nodeNameText = nodeNameText,
    nodeInnerText = nodeInnerText,
    nodeMetadataKeyText = nodeMetadataKeyText,
    nodeMetadataValueText = nodeMetadataValueText,
    nodeAttributeKeyText = nodeAttributeKeyText,
    nodeAttributeValueText = nodeAttributeValueText,
)