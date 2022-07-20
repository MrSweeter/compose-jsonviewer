package be.msdc.xmlviewer_library.internal

import androidx.compose.ui.graphics.Color

/**
 * #fff: #[0-9a-f]{3}
 * #fff: #[0-9a-f]{4}
 * #ffffff: #[0-9a-f]{6}
 * #ffffffff: #[0-9a-f]{8}
 * 0xfff: 0x[0-9a-f]{3}
 * 0xfff: 0x[0-9a-f]{4}
 * 0xffffff: 0x[0-9a-f]{6}
 * 0xffffffff: 0x[0-9a-f]{8}
 * rgb(255, 255, 255): rgb\(\d{1,3},\s?\d{1,3},\s?\d{1,3}\)
 * rgba(255, 255, 255, 1.0): rgba\(\d{1,3},\s?\d{1,3},\s?\d{1,3},\s?[0,1]?\.?[0-9]\)
 */
fun parseColor(color: String): Color? {

    val colorString = color.trim('\"').trim()
    val regex = Regex(pattern = "" +
            "(#[0-9a-f]{3})" +
            "|(#[0-9a-f]{4})" +
            "|(#[0-9a-f]{6})" +
            "|(#[0-9a-f]{8})" +
            "|(0x[0-9a-f]{3})" +
            "|(0x[0-9a-f]{4})" +
            "|(0x[0-9a-f]{6})" +
            "|(0x[0-9a-f]{8})" +
            "|(rgb\\(\\d{1,3},\\s?\\d{1,3},\\s?\\d{1,3}\\))" +
            "|(rgba\\(\\d{1,3},\\s?\\d{1,3},\\s?\\d{1,3},\\s?[0,1]?\\.?[0-9]\\))"
    )

    regex.matchEntire(colorString)?.let { matchResult ->
        val index = matchResult.groupValues.indexOfLast { it.isNotBlank() }
        return when (index) {
            1 -> parseHexa3(colorString.substring(1))
            2 -> parseHexa4(colorString.substring(1))
            3 -> parseHexa6(colorString.substring(1))
            4 -> parseHexa8(colorString.substring(1))
            5 -> parseHexa3(colorString.substring(2))
            6 -> parseHexa4(colorString.substring(2))
            7 -> parseHexa6(colorString.substring(2))
            8 -> parseHexa8(colorString.substring(2))
            9 -> parseRgb(colorString)
            10 -> parseRgba(colorString)
            else -> null
        }
    }
    return null
}

private fun parseHexa3(hexa: String): Color {
    val red = hexa.substring(0, 1).repeat(2).toInt(16)
    val green = hexa.substring(1, 2).repeat(2).toInt(16)
    val blue = hexa.substring(2, 3).repeat(2).toInt(16)
    return Color(red, green, blue)
}

private fun parseHexa4(hexa: String): Color {
    val alpha = hexa.substring(0, 1).repeat(2).toInt(16)
    val red = hexa.substring(1, 2).repeat(2).toInt(16)
    val green = hexa.substring(2, 3).repeat(2).toInt(16)
    val blue = hexa.substring(3, 4).repeat(2).toInt(16)
    return Color(red, green, blue, alpha)
}

private fun parseHexa6(hexa: String): Color {
    val red = hexa.substring(0, 2).toInt(16)
    val green = hexa.substring(2, 4).toInt(16)
    val blue = hexa.substring(4, 6).toInt(16)
    return Color(red, green, blue)
}

private fun parseHexa8(hexa: String): Color {
    val alpha = hexa.substring(0, 2).toInt(16)
    val red = hexa.substring(2, 4).toInt(16)
    val green = hexa.substring(4, 6).toInt(16)
    val blue = hexa.substring(6, 8).toInt(16)
    return Color(red, green, blue, alpha)
}

private fun parseRgb(color: String): Color {
    val rgb = color.substring(3).trim('(').trim(')').replace(" ", "")
    val rgbValues = rgb.split(",")
    return Color(
        red = rgbValues[0].toInt(),
        green = rgbValues[1].toInt(),
        blue = rgbValues[2].toInt(),
    )
}

private fun parseRgba(color: String): Color {
    val rgba = color.substring(4).trim('(').trim(')').replace(" ", "")
    val rgbaValues = rgba.split(",")
    return Color(
        red = rgbaValues[0].toInt(),
        green = rgbaValues[1].toInt(),
        blue = rgbaValues[2].toInt(),
    ).copy(alpha = rgbaValues[3].toFloat())
}