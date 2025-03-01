package com.miksuki.highlightcursor

import com.intellij.openapi.editor.event.EditorFactoryEvent
import com.intellij.openapi.editor.event.EditorFactoryListener

class Editor : EditorFactoryListener {
    override fun editorCreated(event: EditorFactoryEvent) {
        super.editorCreated(event)
        val editor = event.editor
        ColorService.changeCursorColor(listOf(editor))
    }
}
