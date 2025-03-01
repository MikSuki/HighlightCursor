package com.miksuki.highlightcursor

import com.intellij.openapi.editor.event.EditorFactoryEvent
import com.intellij.openapi.editor.event.EditorFactoryListener

class Editor : EditorFactoryListener {
    override fun editorCreated(event: EditorFactoryEvent) {
        super.editorCreated(event)
        val editor = event.editor
        val color = AppSettings.getInstance().state?.colorHex
        color?.let {
            ColorService.changeCursorColor(editor, it)
        }
    }
}
