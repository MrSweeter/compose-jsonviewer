package be.msdc.xmlviewer_library.schemes.dark

import androidx.compose.ui.graphics.Color
import be.msdc.xmlviewer_library.XmlColorScheme

fun DarkScheme.communityMaterial(
    background: Color = Color(0xFF1E1E1E),
    rootIcon: Color = Color(0xffe37933),
    collapseIcon: Color = Color(0xff858585),
    nodeNameText: Color = Color(0xff569cd6),
    nodeInnerText: Color = Color(0xffd4d4d4),
    nodeMetadataKeyText: Color = Color(0xff9cdcfe),
    nodeMetadataValueText: Color = Color(0xffce9178),
    nodeAttributeKeyText: Color = Color(0xff9cdcfe),
    nodeAttributeValueText: Color = Color(0xffce9178),
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