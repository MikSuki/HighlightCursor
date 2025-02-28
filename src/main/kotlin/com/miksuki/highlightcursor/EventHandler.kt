package com.miksuki.highlightcursor

import com.intellij.ide.IdeEventQueue.EventDispatcher
import com.maddyhome.idea.vim.VimPlugin.getEditor
import java.awt.AWTEvent
import java.awt.event.KeyEvent

class EventHandler : EventDispatcher {
    override fun dispatch(event: AWTEvent): Boolean {
        if (event is KeyEvent) {
            println("key event~~~")

            val vimEditor = getEditor()
            vimEditor.getEditors().map { e ->
                println("current vim mode is: ${e.mode}")
            }
        }
        return false
    }
}
