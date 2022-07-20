package be.msdc.jsonviewer_library.schemes.dark

import androidx.compose.ui.graphics.Color
import be.msdc.jsonviewer_library.JsonColorScheme

fun DarkScheme.github(
    background: Color = Color(0xFF24292E),
    rootIcon: Color = Color(0xffcbcb41),
    dropArrowIcon: Color = Color(0xff444d56),
    collectionCounterText: Color = Color(0xFF0366D6),
    collectionLabelText: Color = Color(0xFF6A737D),
    primitiveLabelText: Color = Color(0xff79b8ff),
    primitiveNullText: Color = Color(0xff79b8ff),
    primitiveNumberText: Color = Color(0xff79b8ff),
    primitiveStringText: Color = Color(0xff9ecbff),
    primitiveBooleanTrueText: Color = Color(0xff79b8ff),
    primitiveBooleanFalseText: Color = Color(0xff79b8ff),
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