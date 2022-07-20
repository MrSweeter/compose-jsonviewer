package be.msdc.textformat_viewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import be.msdc.jsonviewer_library.JsonUIRoot
import be.msdc.jsonviewer_library.schemes.dark.*
import be.msdc.jsonviewer_library.schemes.light.*
import be.msdc.jsonviewer_library.utils.readJsonResource
import be.msdc.xmlviewer_library.XmlUIRoot
import be.msdc.xmlviewer_library.schemes.dark.*
import be.msdc.xmlviewer_library.schemes.light.communityMaterial
import be.msdc.xmlviewer_library.schemes.light.github
import be.msdc.xmlviewer_library.schemes.light.winterIsComing
import be.msdc.xmlviewer_library.utils.readXmlResource
import be.msdc.jsonviewer_library.defaultColorScheme as JsonDefaultScheme
import be.msdc.jsonviewer_library.schemes.dark.DarkScheme as JsonDarkScheme
import be.msdc.jsonviewer_library.schemes.light.LightScheme as JsonLightScheme
import be.msdc.xmlviewer_library.defaultColorScheme as XmlDefaultScheme
import be.msdc.xmlviewer_library.schemes.dark.DarkScheme as XmlDarkScheme
import be.msdc.xmlviewer_library.schemes.light.LightScheme as XmlLightScheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val json = readJsonResource(R.raw.scheme_json)
        val xml = readXmlResource(R.raw.scheme_xml)
        setContent {
            Surface(modifier = Modifier, color = MaterialTheme.colorScheme.background) {
                Column(modifier = Modifier.verticalScroll(rememberScrollState(), true)) {
                    JsonUIRoot(json, colorScheme = JsonDefaultScheme())
                    JsonUIRoot(json, colorScheme = JsonDarkScheme.communityMaterial())
                    JsonUIRoot(json, colorScheme = JsonDarkScheme.darcula())
                    JsonUIRoot(json, colorScheme = JsonDarkScheme.dracula())
                    JsonUIRoot(json, colorScheme = JsonDarkScheme.futuristt())
                    JsonUIRoot(json, colorScheme = JsonDarkScheme.github())
                    JsonUIRoot(json, colorScheme = JsonDarkScheme.matrix())
                    JsonUIRoot(json, colorScheme = JsonLightScheme.communityMaterial())
                    JsonUIRoot(json, colorScheme = JsonLightScheme.github())
                    JsonUIRoot(json, colorScheme = JsonLightScheme.winterIsComing())

                    XmlUIRoot(xml, colorScheme = XmlDefaultScheme())
                    XmlUIRoot(xml, colorScheme = XmlDarkScheme.communityMaterial())
                    XmlUIRoot(xml, colorScheme = XmlDarkScheme.darcula())
                    XmlUIRoot(xml, colorScheme = XmlDarkScheme.dracula())
                    XmlUIRoot(xml, colorScheme = XmlDarkScheme.futuristt())
                    XmlUIRoot(xml, colorScheme = XmlDarkScheme.github())
                    XmlUIRoot(xml, colorScheme = XmlDarkScheme.matrix())
                    XmlUIRoot(xml, colorScheme = XmlLightScheme.communityMaterial())
                    XmlUIRoot(xml, colorScheme = XmlLightScheme.github())
                    XmlUIRoot(xml, colorScheme = XmlLightScheme.winterIsComing())
                }
            }
        }
    }
}