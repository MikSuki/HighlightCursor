package com.miksuki.highlightcursor

import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.colors.EditorColors.CARET_COLOR
import java.awt.Color

object ColorService {
    fun changeCursorColor(
        editor: Editor,
        colorHex: String,
    ) {
        editor.colorsScheme.setColor(CARET_COLOR, Color.decode(colorHex))
    }
}
