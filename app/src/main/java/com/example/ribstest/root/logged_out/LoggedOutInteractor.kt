package com.example.ribstest.root.logged_out

import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Coordinates Business Logic for [LoggedOutScope].
 *
 * TODO describe the logic of this scope.
 */
@RibInteractor
class LoggedOutInteractor : Interactor<LoggedOutInteractor.LoggedOutPresenter, LoggedOutRouter>() {

  @Inject
  lateinit var presenter: LoggedOutPresenter

  private val compositeDisposable = CompositeDisposable()

  override fun didBecomeActive(savedInstanceState: Bundle?) {
    super.didBecomeActive(savedInstanceState)
    val disposable = presenter.loginName()
      .subscribe {
        router.startSecondActivity()
      }
    compositeDisposable.add(disposable)
  }

  override fun willResignActive() {
    super.willResignActive()
    compositeDisposable.clear()
  }

  /**
   * Presenter interface implemented by this RIB's view.
   */
  interface LoggedOutPresenter {
    fun loginName(): Observable<String>
  }
}
