package be.msdc.jsonviewer_library.schemes.dark

import androidx.compose.ui.graphics.Color
import be.msdc.jsonviewer_library.JsonColorScheme

fun DarkScheme.futuristt(
    background: Color = Color(0xff000000),
    rootIcon: Color = Color(0xffcbcb41),
    dropArrowIcon: Color = Color(0xff555555),
    collectionCounterText: Color = Color(0xffda70d6),
    collectionLabelText: Color = Color(0xffffd700),
    primitiveLabelText: Color = Color(0xff32d698),
    primitiveNullText: Color = Color(0xffeb0869),
    primitiveNumberText: Color = Color(0xfff09030),
    primitiveStringText: Color = Color(0xfff887ff),
    primitiveBooleanTrueText: Color = Color(0xffeb0869),
    primitiveBooleanFalseText: Color = Color(0xffeb0869),
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