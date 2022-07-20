package be.msdc.jsonviewer_library.utils

import android.content.Context
import androidx.annotation.RawRes
import com.google.gson.JsonElement
import com.google.gson.JsonParser

fun Context.readJsonResource(@RawRes resId: Int): JsonElement {
    val rawJson = resources.openRawResource(resId).bufferedReader().use { it.readText() }
    return JsonParser.parseString(rawJson)
}