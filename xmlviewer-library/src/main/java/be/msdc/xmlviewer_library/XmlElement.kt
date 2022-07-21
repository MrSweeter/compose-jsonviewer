package be.msdc.xmlviewer_library

data class XmlElement(
    val name: String,
    val innerText: List<String>,
    val metadata: Map<String, String>,
    val attributes: Map<String, String>,
    val children: List<XmlElement>,
    var isRoot: Boolean = false
) {
    class Builder {

        private var name: String = "#no name"
        private var innerText: MutableList<String> = mutableListOf()
        private var metadata: MutableMap<String, String> = mutableMapOf()
        private var attributes: MutableMap<String, String> = mutableMapOf()
        private var children: MutableList<XmlElement> = mutableListOf()
        private var isRoot: Boolean = false

        fun addInnerText(innerText: String?) = apply {
            innerText?.let { this.innerText.add(it) }
        }

        fun addMetadata(key: String, value: String?) = apply {
            value?.let { this.metadata[key] = it }
        }

        fun addAttribute(key: String, value: String) = apply {
            attributes[key] = value
        }

        fun addChild(child: XmlElement) = apply {
            children.add(child)
        }

        fun withName(name: String) = apply {
            this.name = name
        }

        fun build(): XmlElement {
            return XmlElement(name, innerText, metadata, attributes, children, isRoot)
        }

    }
}