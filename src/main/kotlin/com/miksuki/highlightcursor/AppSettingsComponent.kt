package com.miksuki.highlightcursor

import com.intellij.ui.ColorPanel
import com.intellij.ui.components.JBCheckBox
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import java.awt.Color
import java.awt.Dimension
import javax.swing.JComponent
import javax.swing.JPanel

object AppSettingsComponent {
    private val myUserText = JBTextField()
    private val myUserStatus = JBCheckBox()
    private var colorPanel =
        ColorPanel().apply {
            preferredSize = Dimension(100, 20)
            maximumSize = Dimension(80, 20)
            selectedColor = Color.decode(AppSettings.state.color)
        }

    val myMainPanel: JPanel =
        FormBuilder
            .createFormBuilder()
            .addLabeledComponent(JBLabel("User name: "), myUserText, 1, false)
            .addComponent(myUserStatus, 1)
            .addLabeledComponent(JBLabel("Choose color: "), colorPanel, 1, false)
            .addComponentFillVertically(JPanel(), 0)
            .panel

    fun getPreferredFocusedComponent(): JComponent = myUserText

    fun getUserNameText(): String = myUserText.getText()

    fun setUserNameText(newText: String) {
        myUserText.setText(newText)
    }

    fun getIdeaUserStatus(): Boolean = myUserStatus.isSelected()

    fun getColor(): String {
        val color: Color = colorPanel.selectedColor ?: Color.RED
        return String.format("#%02X%02X%02X", color.red, color.green, color.blue)
    }

    fun setIdeaUserStatus(newStatus: Boolean) {
        myUserStatus.setSelected(newStatus)
    }
}
