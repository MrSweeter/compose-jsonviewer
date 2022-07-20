package be.msdc.textformat_viewer

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import be.msdc.jsonviewer_library.JsonUIRoot
import be.msdc.jsonviewer_library.defaultColorScheme
import be.msdc.jsonviewer_library.utils.readJsonResource
import be.msdc.xmlviewer_library.XmlUIRoot
import be.msdc.xmlviewer_library.utils.readXmlResource
import org.w3c.dom.Node

class MainActivity : ComponentActivity() {

    private val jsonColorScheme = defaultColorScheme(

    )

    private val xmlColorScheme = be.msdc.xmlviewer_library.defaultColorScheme(

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier, color = MaterialTheme.colorScheme.background) {
                Column {
                    JsonUIRoot(LocalContext.current.readJsonResource(R.raw.sample_json), colorScheme = jsonColorScheme)
                    XmlUIRoot(LocalContext.current.readXmlResource(R.raw.sample_xml), colorScheme = xmlColorScheme)
                }
            }
        }
    }

    private fun log(item: Node, prefix: String = "") {
        val value: String = when(item.nodeType) {
            Node.ELEMENT_NODE -> (item.nodeValue + item.attributes.length)
            Node.TEXT_NODE -> if (item.textContent.trim().isBlank()) return else item.textContent
            else -> "type" + item.nodeType.toString()
        }
        var attrs = ""
        item.attributes?.let {
            for (i in 0 until it.length) {
                attrs += it.item(i).nodeName + "=" + it.item(i).nodeValue + " "
            }
        }

        Log.println(Log.ASSERT, "LOGME", "$prefix${item.nodeName.trim()} | ${value.trim()} | ${item.childNodes?.length} | $attrs")
        for (i in 0 until item.childNodes.length) {
            log(item.childNodes.item(i), "$prefix  ")
        }
    }
}