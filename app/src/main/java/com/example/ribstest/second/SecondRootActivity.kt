package com.example.ribstest.second

import android.content.Context
import android.content.Intent
import android.view.ViewGroup
import com.uber.rib.core.RibActivity
import com.uber.rib.core.ViewRouter

class SecondRootActivity : RibActivity() {
    companion object {
        fun createIntent(context: Context) = Intent(context, SecondRootActivity::class.java)
    }

    override fun createRouter(parentViewGroup: ViewGroup): ViewRouter<*, *, *> {
        val rootBuilder = SecondRootBuilder(object : SecondRootBuilder.ParentComponent {})
        return rootBuilder.build(parentViewGroup)
    }
}