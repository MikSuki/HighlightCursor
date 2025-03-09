package com.miksuki.highlightcursor

import com.intellij.openapi.editor.EditorFactory
import com.intellij.openapi.options.Configurable
import javax.swing.JComponent

class AppSettingsConfigurable : Configurable {
    override fun createComponent(): JComponent = AppSettingsComponent.myMainPanel

    override fun isModified(): Boolean {
        val state = AppSettings.getInstance().state
        return AppSettingsComponent.getVimCustomize() != state?.vimCustomize ||
            AppSettingsComponent.getColorHex() != state.norlmalColorHex ||
            AppSettingsComponent.getVimInsertColor() != state.vimInsertColorHex ||
            AppSettingsComponent.getVimOtherColor() != state.vimOtherColorHex
    }

    override fun apply() {
        val state = AppSettings.getInstance().state
        val color = AppSettingsComponent.getColorHex()
        val vimCustomize = AppSettingsComponent.getVimCustomize()
        val vimInsertcolor = AppSettingsComponent.getVimInsertColor()
        val vimOthercolor = AppSettingsComponent.getVimOtherColor()
        state?.norlmalColorHex = color
        state?.vimCustomize = vimCustomize
        state?.vimInsertColorHex = vimInsertcolor
        state?.vimOtherColorHex = vimOthercolor

        val editors = EditorFactory.getInstance().allEditors
        ColorService.changeCursorColor(editors.toList())
    }

    override fun getDisplayName(): String = "Setting Highlight Cursor"
}
