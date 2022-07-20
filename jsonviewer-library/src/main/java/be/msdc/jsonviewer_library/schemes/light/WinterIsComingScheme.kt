package be.msdc.jsonviewer_library.schemes.light

import androidx.compose.ui.graphics.Color
import be.msdc.jsonviewer_library.JsonColorScheme

fun LightScheme.winterIsComing(
    background: Color = Color(0xffffffff),
    rootIcon: Color = Color(0xffb7b73b),
    dropArrowIcon: Color = Color(0xff2f86d2),
    collectionCounterText: Color = Color(0xFF219FD5),
    collectionLabelText: Color = Color(0x6699D0F7),
    primitiveLabelText: Color = Color(0xff3a9685),
    primitiveNullText: Color = Color(0xffae408b),
    primitiveNumberText: Color = Color(0xff005cc5),
    primitiveStringText: Color = Color(0xff174781),
    primitiveBooleanTrueText: Color = Color(0xffae408b),
    primitiveBooleanFalseText: Color = Color(0xffae408b),
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