package com.example.ribstest.root

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.RouterHelper
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK

import org.junit.Before
import org.junit.Test

class RootRouterTest : RibTestBasePlaceholder() {

  @MockK internal lateinit var component: RootBuilder.Component
  @MockK internal lateinit var interactor: RootInteractor
  @MockK internal lateinit var view: RootView

  private var router: RootRouter? = null

  @Before
  fun setup() {
    MockKAnnotations.init(this)

    router = RootRouter(view, interactor, component)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use RouterHelper to drive your router's lifecycle.
    RouterHelper.attach(router!!)
    RouterHelper.detach(router!!)

    throw RuntimeException("Remove this test and add real tests.")
  }

}

