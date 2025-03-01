package com.miksuki.highlightcursor

import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.colors.EditorColors.CARET_COLOR
import java.awt.Color

object ColorService {
    fun changeCursorColor(
        editors: List<Editor>,
        colorHex: String,
    ) {
        editors.map {
            it.colorsScheme.setColor(CARET_COLOR, Color.decode(colorHex))
        }
    }
}
