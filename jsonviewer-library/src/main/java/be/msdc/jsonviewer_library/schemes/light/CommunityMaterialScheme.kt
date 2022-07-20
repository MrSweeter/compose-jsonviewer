package be.msdc.jsonviewer_library.schemes.light

import androidx.compose.ui.graphics.Color
import be.msdc.jsonviewer_library.JsonColorScheme

fun LightScheme.communityMaterial(
    background: Color = Color(0xffffffff),
    rootIcon: Color = Color(0xffb7b73b),
    dropArrowIcon: Color = Color(0xff2f86d2),
    collectionCounterText: Color = Color(0xFF80CBC4),
    collectionLabelText: Color = Color(0x6690A4AE),
    primitiveLabelText: Color = Color(0xff7c4dff),
    primitiveNullText: Color = Color(0xfff76d47),
    primitiveNumberText: Color = Color(0xfff76d47),
    primitiveStringText: Color = Color(0xff91b859),
    primitiveBooleanTrueText: Color = Color(0xfff76d47),
    primitiveBooleanFalseText: Color = Color(0xfff76d47),
) = JsonColorScheme(
    background = background,
    rootIcon = rootIcon,
    dropArrowIcon = dropArrowIcon,
    collectionCounterText = collectionCounterText,
    collectionLabelText = collectionLabelText,
    primitiveLabelText = primitiveLabelText,
    primitiveNullText = primitiveNullText,
    primitiveNumberText = primitiveNumberText,
    primitiveStringText = primitiveStringText,
    primitiveBooleanTrueText = primitiveBooleanTrueText,
    primitiveBooleanFalseText = primitiveBooleanFalseText,
)