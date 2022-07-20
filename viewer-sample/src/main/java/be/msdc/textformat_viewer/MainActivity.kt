package be.msdc.textformat_viewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import be.msdc.jsonviewer_library.JsonColorScheme
import be.msdc.jsonviewer_library.JsonUIRoot
import be.msdc.jsonviewer_library.schemes.dark.*
import be.msdc.jsonviewer_library.schemes.light.*
import be.msdc.jsonviewer_library.utils.readJsonResource
import be.msdc.xmlviewer_library.XmlColorScheme
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
        setContent {
            Surface(modifier = Modifier, color = MaterialTheme.colorScheme.background) {
                MainContent()
            }
        }
    }
}

@Composable
fun MainContent() {

    val schemes: List<Triple<String, JsonColorScheme, XmlColorScheme>> = listOf(
        Triple("default", JsonDefaultScheme(), XmlDefaultScheme()),
        Triple("communityMaterial dark", JsonDarkScheme.communityMaterial(), XmlDarkScheme.communityMaterial()),
        Triple("darcula", JsonDarkScheme.darcula(), XmlDarkScheme.darcula()),
        Triple("dracula", JsonDarkScheme.dracula(), XmlDarkScheme.dracula()),
        Triple("futuristt", JsonDarkScheme.futuristt(), XmlDarkScheme.futuristt()),
        Triple("github dark", JsonDarkScheme.github(), XmlDarkScheme.github()),
        Triple("matrix", JsonDarkScheme.matrix(), XmlDarkScheme.matrix()),
        Triple("communityMaterial light", JsonLightScheme.communityMaterial(), XmlLightScheme.communityMaterial()),
        Triple("github light", JsonLightScheme.github(), XmlLightScheme.github()),
        Triple("winterIsComing", JsonLightScheme.winterIsComing(), XmlLightScheme.winterIsComing())
    )

    val json = LocalContext.current.readJsonResource(R.raw.scheme_json)
    val xml = LocalContext.current.readXmlResource(R.raw.scheme_xml)

    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("default") }
    var selectedJsonScheme by remember { mutableStateOf(JsonDefaultScheme()) }
    var selectedXmlScheme by remember { mutableStateOf(XmlDefaultScheme()) }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown

    Column {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp)
        ) {
            OutlinedTextField(
                value = selectedText,
                onValueChange = { selectedText = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        textFieldSize = coordinates.size.toSize()
                    },
                label = { Text("Scheme") },
                trailingIcon = {
                    Icon(icon, selectedText, Modifier.clickable { expanded = !expanded })
                }
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.width(with(LocalDensity.current) { textFieldSize.width.toDp() })
            ) {
                schemes.forEach { (name, jsonScheme, xmlScheme) ->
                    DropdownMenuItem(text = { Text(text = name) }, onClick = {
                        selectedJsonScheme = jsonScheme
                        selectedXmlScheme = xmlScheme
                        selectedText = name
                        expanded = false
                    })
                }
            }
        }

        Column(modifier = Modifier.verticalScroll(rememberScrollState(), true)) {

            JsonUIRoot(json, colorScheme = selectedJsonScheme)
            XmlUIRoot(xml, colorScheme = selectedXmlScheme)

            /*
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
            */
        }
    }
}