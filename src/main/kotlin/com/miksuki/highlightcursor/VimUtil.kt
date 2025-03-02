package com.miksuki.highlightcursor

import com.intellij.ide.plugins.PluginManager
import com.intellij.openapi.extensions.PluginId
import com.maddyhome.idea.vim.VimPlugin
import com.maddyhome.idea.vim.VimPlugin.getEditor
import com.maddyhome.idea.vim.state.mode.Mode

object VimUtil {
    private var lastVimMode: Mode = Mode.NORMAL()

    fun isInVimEditor(): Boolean {
        val vimPluginId = PluginId.getId("IdeaVim")
        val isVimInstalled = PluginManager.isPluginInstalled(vimPluginId)
        val isVimEnabled = VimPlugin.isEnabled()

        println("vim install ? $isVimInstalled")
        println("vim enabled ? $isVimEnabled")
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
        println("vim distinct mode length: ${getEditor().getEditors().map { it.mode }.distinct().size}")
        println("current mode is: $currentMode")
        println("current mode is insert?  ${currentMode is Mode.INSERT}")

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
            println("mode change ~~~")
            println("mode change ~~~")
            println("mode change ~~~")
        }

        return isModeChange
    }
}
