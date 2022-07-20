package be.msdc.jsonviewer_library

import androidx.compose.ui.graphics.Color

data class JsonColorScheme(
    val background: Color,
    val rootIcon: Color,
    val dropArrowIcon: Color,
    val collectionCounterText: Color,
    val collectionLabelText: Color,
    val primitiveLabelText: Color,
    val primitiveNullText: Color,
    val primitiveNumberText: Color,
    val primitiveStringText: Color,
    val primitiveBooleanTrueText: Color,
    val primitiveBooleanFalseText: Color,
)

fun defaultColorScheme(
    background: Color = Color.LightGray,
    rootIcon: Color = Color.Black,
    dropArrowIcon: Color = Color.Black,
    collectionCounterText: Color = Color.Black,
    collectionLabelText: Color = Color.Gray,
    primitiveLabelText: Color = Color.Black,
    primitiveNullText: Color = Color.Gray,
    primitiveNumberText: Color = Color(0xFF1E88E5),
    primitiveStringText: Color = Color(0xFF2E7D32),
    primitiveBooleanTrueText: Color = Color(0xFFE64A19),
    primitiveBooleanFalseText: Color = Color(0xFFE64A19),
): JsonColorScheme =
    JsonColorScheme(
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