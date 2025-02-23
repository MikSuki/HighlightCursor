package com.miksuki.highlightcursor

import com.intellij.openapi.editor.colors.EditorColors.*
import com.intellij.openapi.editor.event.EditorFactoryEvent
import com.intellij.openapi.editor.event.EditorFactoryListener
import java.awt.Color

class Editor: EditorFactoryListener {
    override fun editorCreated(event: EditorFactoryEvent) {
        super.editorCreated(event)
        val editor = event.editor
        editor.colorsScheme.setColor(CARET_COLOR, Color.RED)
    }
}