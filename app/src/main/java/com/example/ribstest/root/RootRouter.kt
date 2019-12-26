package com.example.ribstest.root

import com.example.ribstest.root.logged_out.LoggedOutBuilder
import com.example.ribstest.root.logged_out.LoggedOutRouter
import com.uber.rib.core.ViewRouter

/**
 * Adds and removes children of {@link RootBuilder.RootScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class RootRouter(
    view: RootView,
    interactor: RootInteractor,
    component: RootBuilder.Component,
    private val loggedOutBuilder: LoggedOutBuilder
) : ViewRouter<RootView, RootInteractor, RootBuilder.Component>(view, interactor, component) {

    private val loggedOutRoute: LoggedOutRouter by lazy {
        loggedOutBuilder.build(view)
    }

    fun attachLoggedOut() {
        attachChild(loggedOutRoute)
        view.addView(loggedOutRoute.view)
    }

}
