package be.msdc.jsonviewer_library.schemes.dark

import androidx.compose.ui.graphics.Color
import be.msdc.jsonviewer_library.JsonColorScheme

fun DarkScheme.matrix(
    background: Color = Color(0xFF0C0C0C),
    rootIcon: Color = Color(0xffcbcb41),
    dropArrowIcon: Color = Color(0xff006600),
    collectionCounterText: Color = Color(0xff00cc00),
    collectionLabelText: Color = Color(0xFF006600),
    primitiveLabelText: Color = Color(0xff00cc00),
    primitiveNullText: Color = Color(0xff88ff88),
    primitiveNumberText: Color = Color(0xff88ff88),
    primitiveStringText: Color = Color(0xffbbffbb),
    primitiveBooleanTrueText: Color = Color(0xff88ff88),
    primitiveBooleanFalseText: Color = Color(0xff88ff88),
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