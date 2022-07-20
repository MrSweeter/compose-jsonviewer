package be.msdc.jsonviewer_library.internal

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.gson.JsonElement

val ICON_SIZE = 24.dp
val TAB_SIZE = 24.dp
val ROW_HEIGHT = 32.dp

fun Modifier.jsonHeight(json: JsonElement): Modifier {
    val count = json.countElement() - 1
    return this.then(
        heightIn(0.dp, ROW_HEIGHT * count)
    )
}

private fun JsonElement.countElement(): Int {
    return when {
        this.isJsonObject -> this.asJsonObject.entrySet().sumOf { it.value.countElement() } + 1
        this.isJsonArray -> this.asJsonArray.sumOf { it.countElement() } + 1
        else -> 1
    }
}

@Stable
fun Modifier.paddingJson(withIcon: Boolean) = this.then(
    padding(
        start = TAB_SIZE - (if (withIcon) ICON_SIZE else 0.dp),
        end = 8.dp,
    )
)