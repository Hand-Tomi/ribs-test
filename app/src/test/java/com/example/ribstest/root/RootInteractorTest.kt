package com.example.ribstest.root

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.InteractorHelper
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK

import org.junit.Before
import org.junit.Test

class RootInteractorTest : RibTestBasePlaceholder() {

  @MockK internal lateinit var presenter: RootInteractor.RootPresenter
  @MockK internal lateinit var router: RootRouter

  private var interactor: RootInteractor? = null

  @Before
  fun setup() {
    MockKAnnotations.init(this)

    interactor = TestRootInteractor.create(presenter)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use InteractorHelper to drive your interactor's lifecycle.
    InteractorHelper.attach<RootInteractor.RootPresenter, RootRouter>(interactor!!, presenter, router, null)
    InteractorHelper.detach(interactor!!)

    throw RuntimeException("Remove this test and add real tests.")
  }
}