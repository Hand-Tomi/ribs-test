package com.example.ribstest.second

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.RouterHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class SecondRootRouterTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var component: SecondRootBuilder.Component
  @Mock internal lateinit var interactor: SecondRootInteractor
  @Mock internal lateinit var view: SecondRootView

  private var router: SecondRootRouter? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    router = SecondRootRouter(view, interactor, component)
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

