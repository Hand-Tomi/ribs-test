package com.example.ribstest.root.logged_out

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.logged_out_rib.view.*

/**
 * Top level view for {@link LoggedOutBuilder.LoggedOutScope}.
 */
class LoggedOutView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle), LoggedOutInteractor.LoggedOutPresenter {

    override fun loginName(): Observable<String> {
        return RxView.clicks(login_button)
            .map { edit_text.text.toString() }
    }

}
