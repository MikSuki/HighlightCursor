package com.miksuki.highlightcursor

import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.colors.EditorColors.CARET_COLOR
import com.maddyhome.idea.vim.state.mode.Mode
import java.awt.Color

object ColorService {
    fun changeCursorColor(editors: List<Editor>) {
        val color = getSettingColor()
        editors.forEach {
            it.colorsScheme.setColor(CARET_COLOR, color)
        }
    }

    private fun getSettingColor(): Color {
        val state = AppSettings.getInstance().state
            ?: throw Exception("settings state not found")

        val colorHex = if (state.vimCustomize && VimUtil.isInVimEditor()) {
            when (VimUtil.getCurrentMode()) {
                is Mode.INSERT -> state.vimInsertColorHex
                is Mode.NORMAL -> state.vimNormalColorHex
                is Mode.VISUAL -> state.vimVisualColorHex
                is Mode.REPLACE -> state.vimReplaceColorHex
                is Mode.SELECT -> state.vimSelectColorHex
                else -> state.vimOtherColorHex
            }
        } else {
            state.normalColorHex
        }

        return Color.decode(colorHex)
    }
}
