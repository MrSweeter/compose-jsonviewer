package be.msdc.jsonviewer_library.schemes.light

import androidx.compose.ui.graphics.Color
import be.msdc.jsonviewer_library.JsonColorScheme

fun LightScheme.github(
    background: Color = Color(0xffffffff),
    rootIcon: Color = Color(0xffb7b73b),
    dropArrowIcon: Color = Color(0xffbabbbc),
    collectionCounterText: Color = Color(0xFFD73A49),
    collectionLabelText: Color = Color(0x66000000),
    primitiveLabelText: Color = Color(0xff005cc5),
    primitiveNullText: Color = Color(0xff005cc5),
    primitiveNumberText: Color = Color(0xff005cc5),
    primitiveStringText: Color = Color(0xff032f62),
    primitiveBooleanTrueText: Color = Color(0xff005cc5),
    primitiveBooleanFalseText: Color = Color(0xff005cc5),
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