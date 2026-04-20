package com.miksuki.highlightcursor

import com.intellij.ui.ColorPanel
import com.intellij.ui.components.JBCheckBox
import com.intellij.ui.components.JBLabel
import com.intellij.util.ui.FormBuilder
import java.awt.Color
import javax.swing.JPanel

object AppSettingsComponent {
    private val DEFAULT_COLOR = Color.RED

    private val vimCustomize =
        JBCheckBox().apply {
            isSelected = AppSettings.getInstance().state?.vimCustomize ?: false
        }
    private var colorPanel =
        ColorPanel().apply {
            selectedColor = Color.decode(AppSettings.getInstance().state?.normalColorHex)
        }

    private var vimInsertColorPanel =
        ColorPanel().apply {
            selectedColor = Color.decode(AppSettings.getInstance().state?.vimInsertColorHex)
        }
    private var vimNormalColorPanel =
        ColorPanel().apply {
            selectedColor = Color.decode(AppSettings.getInstance().state?.vimNormalColorHex)
        }
    private var vimVisualColorPanel =
        ColorPanel().apply {
            selectedColor = Color.decode(AppSettings.getInstance().state?.vimVisualColorHex)
        }
    private var vimReplaceColorPanel =
        ColorPanel().apply {
            selectedColor = Color.decode(AppSettings.getInstance().state?.vimReplaceColorHex)
        }
    private var vimSelectColorPanel =
        ColorPanel().apply {
            selectedColor = Color.decode(AppSettings.getInstance().state?.vimSelectColorHex)
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
            .addLabeledComponent(JBLabel("Choose the color for normal mode: "), vimNormalColorPanel, 1, false)
            .addVerticalGap(15)
            .addLabeledComponent(JBLabel("Choose the color for visual mode: "), vimVisualColorPanel, 1, false)
            .addVerticalGap(15)
            .addLabeledComponent(JBLabel("Choose the color for replace mode: "), vimReplaceColorPanel, 1, false)
            .addVerticalGap(15)
            .addLabeledComponent(JBLabel("Choose the color for select mode: "), vimSelectColorPanel, 1, false)
            .addVerticalGap(15)
            .addLabeledComponent(
                JBLabel("Choose the color for other modes: "),
                vimOtherColorPanel,
                1,
                false,
            ).addComponentFillVertically(JPanel(), 0)
            .panel

    fun getVimCustomize(): Boolean = vimCustomize.isSelected

    private fun getColorHex(color: Color) = String.format("#%02X%02X%02X", color.red, color.green, color.blue)

    fun getColorHex(): String {
        val color: Color = colorPanel.selectedColor ?: DEFAULT_COLOR
        return getColorHex(color)
    }

    fun getVimInsertColor(): String {
        val color: Color = vimInsertColorPanel.selectedColor ?: DEFAULT_COLOR
        return getColorHex(color)
    }

    fun getVimNormalColor(): String {
        val color: Color = vimNormalColorPanel.selectedColor ?: DEFAULT_COLOR
        return getColorHex(color)
    }

    fun getVimVisualColor(): String {
        val color: Color = vimVisualColorPanel.selectedColor ?: DEFAULT_COLOR
        return getColorHex(color)
    }

    fun getVimReplaceColor(): String {
        val color: Color = vimReplaceColorPanel.selectedColor ?: DEFAULT_COLOR
        return getColorHex(color)
    }

    fun getVimSelectColor(): String {
        val color: Color = vimSelectColorPanel.selectedColor ?: DEFAULT_COLOR
        return getColorHex(color)
    }

    fun getVimOtherColor(): String {
        val color: Color = vimOtherColorPanel.selectedColor ?: DEFAULT_COLOR
        return getColorHex(color)
    }
}
