package com.miksuki.highlightcursor

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import org.jetbrains.annotations.NonNls
import org.jetbrains.annotations.NotNull

@State(
    name = "com.miksuki.highlightCursor.AppSettings",
    storages = [Storage("HighLightCursorPlugin.xml")],
)
object AppSettings : PersistentStateComponent<AppSettings.State> {
    class State {
        @JvmField
        @NonNls
        var userId = "John Smith"

        @JvmField
        @NonNls
        var color = "#FF0000"

        @JvmField
        var ideaStatus = false
    }

    var myState = State()

    override fun getState(): State = myState

    override fun loadState(
        @NotNull newState: State,
    ) {
        myState = newState
    }
}
