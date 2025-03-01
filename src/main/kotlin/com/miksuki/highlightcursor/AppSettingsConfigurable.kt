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
            AppSettingsComponent.getColor() != state?.colorHex
    }

    override fun apply() {
        val state = AppSettings.getInstance().state
        val color = AppSettingsComponent.getColor()
        state?.userId = AppSettingsComponent.getUserNameText()
        state?.colorHex = color
        state?.ideaStatus = AppSettingsComponent.getIdeaUserStatus()

        val editors = EditorFactory.getInstance().allEditors
        color.let {
            ColorService.changeCursorColor(editors.toList(), it)
        }
    }

    override fun getDisplayName(): String = "Setting Highlight Cursor"
}
