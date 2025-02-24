package com.miksuki.highlightcursor

import com.intellij.openapi.editor.EditorFactory
import com.intellij.openapi.editor.colors.EditorColors.CARET_COLOR
import com.intellij.openapi.options.Configurable
import java.awt.Color
import javax.swing.JComponent

class AppSettingsConfigurable : Configurable {
    override fun createComponent(): JComponent = AppSettingsComponent.myMainPanel

    override fun isModified(): Boolean {
        val state = AppSettings.state
        return AppSettingsComponent.getUserNameText() != state.userId ||
            AppSettingsComponent.getIdeaUserStatus() != state.ideaStatus ||
            AppSettingsComponent.getColor() != state.color
    }

    override fun apply() {
        val state = AppSettings.state
        val color = AppSettingsComponent.getColor()
        state.userId = AppSettingsComponent.getUserNameText()
        state.color = color
        state.ideaStatus = AppSettingsComponent.getIdeaUserStatus()

        EditorFactory.getInstance().allEditors.map { editor ->
            editor.colorsScheme.setColor(CARET_COLOR, Color.decode(color))
        }
    }

    override fun getDisplayName(): String = "Setting Highlight Cursor"
}
