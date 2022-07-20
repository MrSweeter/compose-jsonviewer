package be.msdc.xmlviewer_library

import android.util.Log
import org.w3c.dom.Node
import java.nio.charset.Charset
import javax.xml.parsers.DocumentBuilderFactory

object XmlParser {
    fun parseString(xml: String, charset: Charset = Charsets.UTF_8): XmlElement? {
        val factory = DocumentBuilderFactory.newInstance()
        factory.isNamespaceAware = true
        try {
            val builder = factory.newDocumentBuilder()
            xml.byteInputStream(charset).use { inputStream ->
                return builder.parse(inputStream)?.let { mapNode(it).apply { isRoot = true } }
            }
        } catch (e: Exception) {
            Log.e("XmlParser", "Error parsing XML", e)
        }
        return null
    }

    private fun mapNode(node: Node): XmlElement {
        val builder = XmlElement.Builder()

        if (node.hasAttributes()) {
            for (i in 0 until node.attributes.length) {
                val attr = node.attributes.item(i)
                builder.addAttribute(attr.nodeName, attr.nodeValue)
            }
        }

        if (node.hasChildNodes()) {
            for (i in 0 until node.childNodes.length) {
                val child = node.childNodes.item(i)
                if (child.nodeType == Node.TEXT_NODE) {
                    builder.addInnerText(child.textContent.trim())
                } else {
                    builder.addChild(mapNode(child))
                }
            }
        }

        return builder.build(node.nodeName)
    }
}