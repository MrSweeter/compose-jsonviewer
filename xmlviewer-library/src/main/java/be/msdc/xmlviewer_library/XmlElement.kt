package be.msdc.xmlviewer_library

data class XmlElement(
    val name: String,
    val innerText: List<String>,
    val attributes: Map<String, String>,
    val children: List<XmlElement>,
    var isRoot: Boolean = false
) {
    class Builder {

        private var innerText: MutableList<String> = mutableListOf()
        private var attributes: MutableMap<String, String> = mutableMapOf()
        private var children: MutableList<XmlElement> = mutableListOf()
        private var isRoot: Boolean = false

        fun addInnerText(innerText: String) = apply {
            this.innerText.add(innerText)
        }

        fun addAttribute(key: String, value: String) = apply {
            attributes[key] = value
        }

        fun addChild(child: XmlElement) = apply {
            children.add(child)
        }

        fun build(name: String): XmlElement {
            return XmlElement(name, innerText, attributes, children, isRoot)
        }
    }
}