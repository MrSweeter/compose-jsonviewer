package be.msdc.jsonviewer_library.schemes.dark

import androidx.compose.ui.graphics.Color
import be.msdc.jsonviewer_library.JsonColorScheme

fun DarkScheme.dracula(
    background: Color = Color(0xFF282A36),
    rootIcon: Color = Color(0xffcbcb41),
    dropArrowIcon: Color = Color(0xff6272a4),
    collectionCounterText: Color = Color(0xFFFF79C6),
    collectionLabelText: Color = Color(0xFF6272A4),
    primitiveLabelText: Color = Color(0xff8be9fd),
    primitiveNullText: Color = Color(0xffbd93f9),
    primitiveNumberText: Color = Color(0xffbd93f9),
    primitiveStringText: Color = Color(0xfff1fa8c),
    primitiveBooleanTrueText: Color = Color(0xffbd93f9),
    primitiveBooleanFalseText: Color = Color(0xffbd93f9),
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