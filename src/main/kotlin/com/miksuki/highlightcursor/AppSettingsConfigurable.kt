package com.miksuki.highlightcursor

import com.intellij.openapi.editor.EditorFactory
import com.intellij.openapi.options.Configurable
import javax.swing.JComponent

class AppSettingsConfigurable : Configurable {
    override fun createComponent(): JComponent = AppSettingsComponent.myMainPanel

    override fun isModified(): Boolean {
        val state = AppSettings.getInstance().state
        return AppSettingsComponent.getUserNameText() != state?.userId ||
            AppSettingsComponent.getIdeaUserStatus() != state?.ideaStatus ||
            AppSettingsComponent.getColor() != state?.colorHex ||
            AppSettingsComponent.getVimInsertColor() != state?.vimInsertColorHex ||
            AppSettingsComponent.getVimOtherColor() != state?.vimOtherColorHex
    }

    override fun apply() {
        val state = AppSettings.getInstance().state
        val color = AppSettingsComponent.getColor()
        val vimInsertcolor = AppSettingsComponent.getVimInsertColor()
        val vimOthercolor = AppSettingsComponent.getVimOtherColor()
        state?.userId = AppSettingsComponent.getUserNameText()
        state?.colorHex = color
        state?.vimInsertColorHex = vimInsertcolor
        state?.vimOtherColorHex = vimOthercolor
        state?.ideaStatus = AppSettingsComponent.getIdeaUserStatus()

        val editors = EditorFactory.getInstance().allEditors
        ColorService.changeCursorColor(editors.toList())
    }

    override fun getDisplayName(): String = "Setting Highlight Cursor"
}
