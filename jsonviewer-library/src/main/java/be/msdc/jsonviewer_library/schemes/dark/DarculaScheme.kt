package be.msdc.jsonviewer_library.schemes.dark

import androidx.compose.ui.graphics.Color
import be.msdc.jsonviewer_library.JsonColorScheme

fun DarkScheme.darcula(
    background: Color = Color(0xFF242424),
    rootIcon: Color = Color(0xffcbcb41),
    dropArrowIcon: Color = Color(0xff858585),
    collectionCounterText: Color = Color(0xFF007ACC),
    collectionLabelText: Color = Color(0x66FFFFFF),
    primitiveLabelText: Color = Color(0xff6a8759),
    primitiveNullText: Color = Color(0xffcc8242),
    primitiveNumberText: Color = Color(0xff7a9ec2),
    primitiveStringText: Color = Color(0xff6a8759),
    primitiveBooleanTrueText: Color = Color(0xffcc8242),
    primitiveBooleanFalseText: Color = Color(0xffcc8242),
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