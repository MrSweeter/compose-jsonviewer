package be.msdc.xmlviewer_library.schemes.light

import androidx.compose.ui.graphics.Color
import be.msdc.xmlviewer_library.XmlColorScheme

fun LightScheme.winterIsComing(
    background: Color = Color(0xffffffff),
    rootIcon: Color = Color(0xffcc6d2e),
    collapseIcon: Color = Color(0xff2f86d2),
    nodeNameText: Color = Color(0xff0444ac),
    nodeInnerText: Color = Color(0xff236ebf),
    nodeMetadataKeyText: Color = Color(0xffdf8618),
    nodeMetadataValueText: Color = Color(0xffa44185),
    nodeAttributeKeyText: Color = Color(0xffdf8618),
    nodeAttributeValueText: Color = Color(0xffa44185),
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