package be.msdc.jsonviewer_library.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color

object JsonViewer   {
    val colorScheme: JsonColorScheme
        @Composable
        @ReadOnlyComposable
        get() = jsonColorScheme

    private var jsonColorScheme = defaultColorScheme()

    fun update(jsonColorScheme: JsonColorScheme)    {
        this.jsonColorScheme = jsonColorScheme
    }
}

@Stable
data class JsonColorScheme(
    val background: Color,
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