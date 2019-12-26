package com.example.ribstest.second

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ribstest.R
import com.uber.rib.core.InteractorBaseComponent
import com.uber.rib.core.ViewBuilder
import dagger.Binds
import dagger.BindsInstance
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Scope

/**
 * Builder for the {@link SecondScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
class SecondRootBuilder(dependency: ParentComponent) : ViewBuilder<SecondRootView, SecondRootRouter, SecondRootBuilder.ParentComponent>(dependency) {

  /**
   * Builds a new [SecondRootRouter].
   *
   * @param parentViewGroup parent view group that this router's view will be added to.
   * @return a new [SecondRootRouter].
   */
  fun build(parentViewGroup: ViewGroup): SecondRootRouter {
    val view = createView(parentViewGroup)
    val interactor = SecondRootInteractor()
    val component = DaggerSecondRootBuilder_Component.builder()
        .parentComponent(dependency)
        .view(view)
        .interactor(interactor)
        .build()
    return component.secondRouter()
  }

  override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): SecondRootView? {
    return inflater.inflate(R.layout.second_root_rib, parentViewGroup, false) as SecondRootView
  }

  interface ParentComponent {
    // TODO: Define dependencies required from your parent interactor here.
  }

  @dagger.Module
  abstract class Module {

    @SecondScope
    @Binds
    internal abstract fun presenter(view: SecondRootView): SecondRootInteractor.SecondPresenter

    @dagger.Module
    companion object {

      @SecondScope
      @Provides
      @JvmStatic
      internal fun router(
        component: Component,
        view: SecondRootView,
        interactor: SecondRootInteractor): SecondRootRouter {
        return SecondRootRouter(view, interactor, component)
      }
    }

    // TODO: Create provider methods for dependencies created by this Rib. These should be static.
  }

  @SecondScope
  @dagger.Component(modules = [Module::class], dependencies = [ParentComponent::class])
  interface Component : InteractorBaseComponent<SecondRootInteractor>, BuilderComponent {

    @dagger.Component.Builder
    interface Builder {
      @BindsInstance
      fun interactor(interactor: SecondRootInteractor): Builder

      @BindsInstance
      fun view(view: SecondRootView): Builder

      fun parentComponent(component: ParentComponent): Builder
      fun build(): Component
    }
  }

  interface BuilderComponent {
    fun secondRouter(): SecondRootRouter
  }

  @Scope
  @kotlin.annotation.Retention(AnnotationRetention.BINARY)
  internal annotation class SecondScope

  @Qualifier
  @kotlin.annotation.Retention(AnnotationRetention.BINARY)
  internal annotation class SecondInternal
}
