package com.example.ribstest.second

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

/**
 * Top level view for {@link SecondBuilder.SecondScope}.
 */
class SecondRootView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle), SecondRootInteractor.SecondPresenter
