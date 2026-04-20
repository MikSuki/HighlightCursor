package com.miksuki.highlightcursor

import com.intellij.openapi.editor.EditorFactory
import com.intellij.openapi.options.Configurable
import javax.swing.JComponent

class AppSettingsConfigurable : Configurable {
    override fun createComponent(): JComponent = AppSettingsComponent.myMainPanel

    override fun isModified(): Boolean {
        val state = AppSettings.getInstance().state
        return AppSettingsComponent.getVimCustomize() != state?.vimCustomize ||
            AppSettingsComponent.getColorHex() != state.normalColorHex ||
            AppSettingsComponent.getVimInsertColor() != state.vimInsertColorHex ||
            AppSettingsComponent.getVimNormalColor() != state.vimNormalColorHex ||
            AppSettingsComponent.getVimVisualColor() != state.vimVisualColorHex ||
            AppSettingsComponent.getVimReplaceColor() != state.vimReplaceColorHex ||
            AppSettingsComponent.getVimSelectColor() != state.vimSelectColorHex ||
            AppSettingsComponent.getVimOtherColor() != state.vimOtherColorHex
    }

    override fun apply() {
        val state = AppSettings.getInstance().state
        state?.normalColorHex = AppSettingsComponent.getColorHex()
        state?.vimCustomize = AppSettingsComponent.getVimCustomize()
        state?.vimInsertColorHex = AppSettingsComponent.getVimInsertColor()
        state?.vimNormalColorHex = AppSettingsComponent.getVimNormalColor()
        state?.vimVisualColorHex = AppSettingsComponent.getVimVisualColor()
        state?.vimReplaceColorHex = AppSettingsComponent.getVimReplaceColor()
        state?.vimSelectColorHex = AppSettingsComponent.getVimSelectColor()
        state?.vimOtherColorHex = AppSettingsComponent.getVimOtherColor()

        val editors = EditorFactory.getInstance().allEditors
        ColorService.changeCursorColor(editors.toList())
    }

    override fun getDisplayName(): String = "Setting Highlight Cursor"
}
