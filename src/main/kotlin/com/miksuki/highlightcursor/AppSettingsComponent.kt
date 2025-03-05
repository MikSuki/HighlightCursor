package com.miksuki.highlightcursor

import com.intellij.ui.ColorPanel
import com.intellij.ui.components.JBCheckBox
import com.intellij.ui.components.JBLabel
import com.intellij.util.ui.FormBuilder
import java.awt.Color
import javax.swing.JPanel

object AppSettingsComponent {
    private val vimCustomize =
        JBCheckBox().apply {
            isSelected = AppSettings.getInstance().state?.vimCustomize ?: false
        }
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
            .addLabeledComponent(JBLabel("Choose your color: "), colorPanel, 1, false)
            .addVerticalGap(15)
            .addSeparator(5)
            .addVerticalGap(15)
            .addComponent(JBLabel("----- If vim is not installed, the following settings will not work -----"))
            .addVerticalGap(15)
            .addLabeledComponent(JBLabel("Enable vim customize settings"), vimCustomize, 1, false)
            .addVerticalGap(15)
            .addLabeledComponent(JBLabel("Choose the color for insert mode: "), vimInsertColorPanel, 1, false)
            .addVerticalGap(15)
            .addLabeledComponent(
                JBLabel("Choose the color for other mode(normal, view, ...): "),
                vimOtherColorPanel,
                1,
                false,
            ).addComponentFillVertically(JPanel(), 0)
            .panel

    fun getVimCustomize(): Boolean = vimCustomize.isSelected()

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
}
