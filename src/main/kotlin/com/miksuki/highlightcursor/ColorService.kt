package com.miksuki.highlightcursor

import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.colors.EditorColors.CARET_COLOR
import java.awt.Color

object ColorService {
    fun changeCursorColor(editors: List<Editor>) {
        val color = getSettingColor()
        editors.map {
            it.colorsScheme.setColor(CARET_COLOR, color)
        }
    }

    private fun getSettingColor(): Color? {
        val state = AppSettings.getInstance().state

        val colorHex =
            when (true) {
                (state?.vimCustomize == true && VimUtil.isInVimEditor()) ->
                    if (VimUtil.isInsertMode()) {
                        state?.vimInsertColorHex
                    } else {
                        state?.vimOtherColorHex
                    }

                else -> state?.colorHex
            }
        colorHex?.let {
            return Color.decode(it)
        } ?: throw Exception("color not found :(")
    }
}
