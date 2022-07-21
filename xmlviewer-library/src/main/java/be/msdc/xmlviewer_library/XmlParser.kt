package be.msdc.xmlviewer_library

import android.util.Log
import org.w3c.dom.*
import org.w3c.dom.Node.*
import java.nio.charset.Charset
import javax.xml.parsers.DocumentBuilderFactory

object XmlParser {
    fun parseString(xml: String, charset: Charset = Charsets.UTF_8): XmlElement? {
        val factory = DocumentBuilderFactory.newInstance()
        factory.isNamespaceAware = true
        try {
            val builder = factory.newDocumentBuilder()
            xml.byteInputStream(charset).use { inputStream ->
                return builder.parse(inputStream)?.let { visit(it).apply { isRoot = true } }
            }
        } catch (e: Exception) {
            Log.e("XmlParser", "Error parsing XML", e)
        }
        return null
    }

    private fun visit(node: Node): XmlElement {
        val builder = when (node.nodeType) {
            ATTRIBUTE_NODE -> visitAttribute(node)
            CDATA_SECTION_NODE -> visitCDATASection(node)
            COMMENT_NODE -> visitComment(node)
            DOCUMENT_FRAGMENT_NODE -> visitDocumentFragment(node)
            DOCUMENT_NODE -> visitDocument(node)
            DOCUMENT_TYPE_NODE -> visitDocumentType(node)
            ELEMENT_NODE -> visitElement(node)
            ENTITY_NODE -> visitEntity(node)
            ENTITY_REFERENCE_NODE -> visitEntityReference(node)
            NOTATION_NODE -> visitNotation(node)
            PROCESSING_INSTRUCTION_NODE -> visitProcessingInstruction(node)
            TEXT_NODE -> visitText(node)
            else -> XmlElement.Builder().withName(node.nodeName)
        }

        if (node.hasAttributes()) {
            for (i in 0 until node.attributes.length) {
                val attr = node.attributes.item(i)
                builder.addAttribute(attr.nodeName, attr.nodeValue)
            }
        }

        if (node.hasChildNodes()) {
            for (i in 0 until node.childNodes.length) {
                val child = node.childNodes.item(i)
                if (child.nodeType == TEXT_NODE) {
                    builder.addInnerText(child.textContent.trim())
                } else {
                    builder.addChild(visit(child))
                }
            }
        }

        return builder.build()
    }

    private fun visitAttribute(node: Node): XmlElement.Builder {
        node as Attr
        return XmlElement.Builder()
            .withName(node.name)
            .addInnerText(node.value ?: "no value")
    }

    private fun visitCDATASection(node: Node): XmlElement.Builder {
        node as CDATASection
        return XmlElement.Builder()
            .withName(node.nodeName)
            .addInnerText(node.wholeText ?: "empty section")
    }

    private fun visitComment(node: Node): XmlElement.Builder {
        node as Comment
        return XmlElement.Builder()
            .withName(node.nodeName)
            .addInnerText(node.data ?: "no comment")
    }

    private fun visitDocumentFragment(node: Node): XmlElement.Builder {
        node as DocumentFragment
        return XmlElement.Builder()
            .withName(node.nodeName)
    }

    private fun visitDocument(node: Node): XmlElement.Builder {
        node as Document
        return XmlElement.Builder()
            .withName(node.nodeName)
            .addMetadata("docType", node.doctype?.name)
            .addMetadata("xmlVersion", node.xmlVersion)
            .addMetadata("xmlEncoding", node.xmlEncoding)
            .addMetadata("uri", node.documentURI)
    }

    private fun visitDocumentType(node: Node): XmlElement.Builder {
        node as DocumentType
        return XmlElement.Builder()
            .withName(node.name)
            .addMetadata("publicId", node.publicId)
            .addMetadata("systemId", node.systemId)
            .addMetadata("internalSubset", node.internalSubset)
    }

    private fun visitElement(node: Node): XmlElement.Builder {
        node as Element
        return XmlElement.Builder()
            .withName(node.nodeName)
    }

    private fun visitEntity(node: Node): XmlElement.Builder {
        node as Entity
        return XmlElement.Builder()
            .withName(node.nodeName)
            .addMetadata("publicId", node.publicId)
            .addMetadata("systemId", node.systemId)
            .addMetadata("notationName", node.notationName)
            .addMetadata("inputEncoding", node.inputEncoding)
            .addMetadata("xmlEncoding", node.xmlEncoding)
            .addMetadata("xmlVersion", node.xmlVersion)
    }

    private fun visitEntityReference(node: Node): XmlElement.Builder {
        node as EntityReference
        return XmlElement.Builder()
            .withName(node.nodeName)
    }

    private fun visitNotation(node: Node): XmlElement.Builder {
        node as Notation
        return XmlElement.Builder()
            .withName(node.nodeName)
            .addMetadata("publicId", node.publicId)
            .addMetadata("systemId", node.systemId)
    }

    private fun visitProcessingInstruction(node: Node): XmlElement.Builder {
        node as ProcessingInstruction
        return XmlElement.Builder()
            .withName(node.nodeName)
            .addMetadata("target", node.target)
            .addMetadata("data", node.data)
    }

    private fun visitText(node: Node): XmlElement.Builder {
        node as Text
        return XmlElement.Builder()
            .withName(node.nodeName)
            .addInnerText(node.wholeText ?: "no text")
    }
}