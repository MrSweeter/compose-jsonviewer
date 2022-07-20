package be.msdc.xmlviewer_library.utils

import android.content.Context
import androidx.annotation.RawRes
import be.msdc.xmlviewer_library.XmlElement
import be.msdc.xmlviewer_library.XmlParser

fun Context.readXmlResource(@RawRes resId: Int): XmlElement? {
    val rawXml = resources.openRawResource(resId).bufferedReader().use { it.readText() }
    return XmlParser.parseString(rawXml)
}