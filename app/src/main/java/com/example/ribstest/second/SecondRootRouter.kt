package com.example.ribstest.second

import com.uber.rib.core.ViewRouter

/**
 * Adds and removes children of {@link SecondBuilder.SecondScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class SecondRootRouter(
    view: SecondRootView,
    interactor: SecondRootInteractor,
    component: SecondRootBuilder.Component) : ViewRouter<SecondRootView, SecondRootInteractor, SecondRootBuilder.Component>(view, interactor, component)
