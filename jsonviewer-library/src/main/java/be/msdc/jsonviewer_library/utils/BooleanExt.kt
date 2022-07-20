package be.msdc.jsonviewer_library.utils

fun Boolean.toggle(): Boolean {
    return this.not()
}