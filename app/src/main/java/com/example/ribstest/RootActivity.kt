package com.example.ribstest

import android.view.ViewGroup
import com.example.ribstest.root.RootBuilder
import com.uber.rib.core.RibActivity
import com.uber.rib.core.ViewRouter

class RootActivity : RibActivity() {

    override fun createRouter(parentViewGroup: ViewGroup): ViewRouter<*, *, *> {
        val rootBuilder = RootBuilder(object : RootBuilder.ParentComponent {})
        return rootBuilder.build(parentViewGroup)
    }
}
