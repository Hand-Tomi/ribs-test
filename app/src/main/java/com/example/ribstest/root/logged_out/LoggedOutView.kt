package com.example.ribstest.root.logged_out

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 * Top level view for {@link LoggedOutBuilder.LoggedOutScope}.
 */
class LoggedOutView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : View(context, attrs, defStyle), LoggedOutInteractor.LoggedOutPresenter