package com.miksuki.highlightcursor

import com.intellij.openapi.editor.colors.EditorColors.*
import com.intellij.openapi.editor.event.EditorFactoryEvent
import com.intellij.openapi.editor.event.EditorFactoryListener
import com.maddyhome.idea.vim.VimPlugin.getEditor
import java.awt.Color

class Editor : EditorFactoryListener {
    override fun editorCreated(event: EditorFactoryEvent) {
        super.editorCreated(event)
        val editor = event.editor
        editor.colorsScheme.setColor(CARET_COLOR, Color.decode(AppSettings.getInstance().state?.color))
        val vimEditor = getEditor()
        vimEditor.getEditors().map { e ->
            println("current vim mode is: ${e.mode}")
        }
    }
}
