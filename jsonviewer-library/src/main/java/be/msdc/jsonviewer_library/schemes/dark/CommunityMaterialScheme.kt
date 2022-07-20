package be.msdc.jsonviewer_library.schemes.dark

import androidx.compose.ui.graphics.Color
import be.msdc.jsonviewer_library.JsonColorScheme

fun DarkScheme.communityMaterial(
    background: Color = Color(0xFF1E1E1E),
    rootIcon: Color = Color(0xffcbcb41),
    dropArrowIcon: Color = Color(0xff858585),
    collectionCounterText: Color = Color(0xFF007ACC),
    collectionLabelText: Color = Color(0x66FFFFFF),
    primitiveLabelText: Color = Color(0xff79b8ff),
    primitiveNullText: Color = Color(0xff569cd6),
    primitiveNumberText: Color = Color(0xffbecea8),
    primitiveStringText: Color = Color(0xffce9178),
    primitiveBooleanTrueText: Color = Color(0xff569cd6),
    primitiveBooleanFalseText: Color = Color(0xff569cd6),
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