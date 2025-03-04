package com.miksuki.highlightcursor

import com.intellij.ui.ColorPanel
import com.intellij.ui.components.JBCheckBox
import com.intellij.ui.components.JBLabel
import com.intellij.util.ui.FormBuilder
import java.awt.Color
import javax.swing.JPanel

object AppSettingsComponent {
    private val myUserStatus = JBCheckBox()
    private var colorPanel =
        ColorPanel().apply {
            selectedColor = Color.decode(AppSettings.getInstance().state?.colorHex)
        }

    private var vimInsertColorPanel =
        ColorPanel().apply {
            selectedColor = Color.decode(AppSettings.getInstance().state?.vimInsertColorHex)
        }
    private var vimOtherColorPanel =
        ColorPanel().apply {
            selectedColor = Color.decode(AppSettings.getInstance().state?.vimOtherColorHex)
        }

    val myMainPanel: JPanel =
        FormBuilder
            .createFormBuilder()
            .addComponent(myUserStatus, 1)
            .addLabeledComponent(JBLabel("Choose color: "), colorPanel, 1, false)
            .addLabeledComponent(JBLabel("Choose vim insert color: "), vimInsertColorPanel, 1, false)
            .addLabeledComponent(JBLabel("Choose vim other color: "), vimOtherColorPanel, 1, false)
            .addComponentFillVertically(JPanel(), 0)
            .panel

    fun getIdeaUserStatus(): Boolean = myUserStatus.isSelected()

    fun getColor(): String {
        val color: Color = colorPanel.selectedColor ?: Color.RED
        return String.format("#%02X%02X%02X", color.red, color.green, color.blue)
    }

    fun getVimInsertColor(): String {
        val color: Color = vimInsertColorPanel.selectedColor ?: Color.RED
        return String.format("#%02X%02X%02X", color.red, color.green, color.blue)
    }

    fun getVimOtherColor(): String {
        val color: Color = vimOtherColorPanel.selectedColor ?: Color.RED
        return String.format("#%02X%02X%02X", color.red, color.green, color.blue)
    }

    fun setIdeaUserStatus(newStatus: Boolean) {
        myUserStatus.setSelected(newStatus)
    }
}
