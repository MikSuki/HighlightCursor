package com.miksuki.highlightcursor

import com.intellij.ide.IdeEventQueue.EventDispatcher
import com.intellij.openapi.editor.EditorFactory
import com.maddyhome.idea.vim.state.mode.Mode
import java.awt.AWTEvent
import java.awt.event.KeyEvent

class EventHandler : EventDispatcher {
    // TODO: capture mode change from vim
    private var lastVimMode: Mode = Mode.NORMAL()

    override fun dispatch(event: AWTEvent): Boolean {
        if (event is KeyEvent && VimUtil.isInVimEditor()) {
            if (VimUtil.checkVimModeChange()) {
                println("vim mode change ~~~")
                val editors = EditorFactory.getInstance().allEditors
                ColorService.changeCursorColor(editors.toList())
            }
        }
        return false
    }
}
