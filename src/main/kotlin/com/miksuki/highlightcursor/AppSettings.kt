package com.miksuki.highlightcursor

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import org.jetbrains.annotations.NonNls
import org.jetbrains.annotations.NotNull

@State(
    name = "com.miksuki.highlightCursor.AppSettings",
    storages = [Storage("HighLightCursorPlugin.xml")],
)
class AppSettings : PersistentStateComponent<MyState> {
    private var myState = MyState()

    override fun getState(): MyState = myState

    override fun loadState(
        @NotNull newState: MyState,
    ) {
        myState = newState
    }

    companion object {
        @JvmStatic
        fun getInstance(): PersistentStateComponent<MyState> =
            ApplicationManager
                .getApplication()
                .getService(AppSettings::class.java)
    }
}

data class MyState(
    @NonNls
    var norlmalColorHex: String = "#FF0000",
    @NonNls
    var vimInsertColorHex: String = "#FF0000",
    @NonNls
    var vimOtherColorHex: String = "#FF0000",
    @NonNls
    var vimCustomize: Boolean = false,
)
