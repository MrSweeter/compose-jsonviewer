package be.msdc.jsonviewer_library.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import be.msdc.jsonviewer_library.utils.TAB_SIZE
import be.msdc.jsonviewer_library.utils.jsonHeight
import be.msdc.jsonviewer_library.utils.toggle
import com.google.gson.JsonElement

@Composable
fun JsonUICollection(
    element: JsonElement,
    label: String?,
    content: LazyListScope.() -> Unit
)   {
    var expanded by remember { mutableStateOf(false) }
    val rotation by animateFloatAsState(targetValue = if (expanded) 0f else -90f)

    Column {
        JsonUIExpandable(
            label = label,
            element = element,
            rotation = rotation,
            onClick = { expanded = expanded.toggle() },
        )
        AnimatedVisibility(
            visible = expanded,
            modifier = Modifier.padding(start = TAB_SIZE)
        ) {
            LazyColumn(modifier = Modifier.jsonHeight(element), content = content)
        }
    }
}