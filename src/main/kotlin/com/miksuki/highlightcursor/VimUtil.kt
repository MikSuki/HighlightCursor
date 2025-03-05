package com.miksuki.highlightcursor

import com.intellij.ide.plugins.PluginManager
import com.intellij.openapi.extensions.PluginId
import com.maddyhome.idea.vim.VimPlugin
import com.maddyhome.idea.vim.VimPlugin.getEditor
import com.maddyhome.idea.vim.state.mode.Mode

object VimUtil {
    private var lastVimMode: Mode? = null

    fun isInVimEditor(): Boolean {
        val vimPluginId = PluginId.getId("IdeaVim")
        val isVimInstalled = PluginManager.isPluginInstalled(vimPluginId)
        val isVimEnabled = VimPlugin.isEnabled()

        return isVimEnabled
//        return isVimInstalled && isVimEnabled
    }

    fun getCurrentMode(): Mode {
        val currentMode =
            try {
                getEditor()
                    .getEditors()
                    .map { it.mode }[0]
            } catch (e: Exception) {
                Mode.NORMAL()
            }
        return currentMode
    }

    fun isInsertMode(): Boolean {
        val currentMode = getCurrentMode()
        return currentMode is Mode.INSERT
    }

    fun checkVimModeChange(): Boolean {
        val currentMode = getCurrentMode()

        val isModeChange = lastVimMode != currentMode
        if (isModeChange) {
            lastVimMode = currentMode
        }

        return isModeChange
    }
}
