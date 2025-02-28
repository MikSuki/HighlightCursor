package com.miksuki.highlightcursor

import com.intellij.ide.IdeEventQueue
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity

class Startup : ProjectActivity {
    override suspend fun execute(project: Project) {
        // can change to VimListenersNotifier, when it is stable
        IdeEventQueue.getInstance().addPostEventListener(EventHandler()::onPost, project)
    }
}
