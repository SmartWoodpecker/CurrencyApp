package rudenko.andrey.currencyapp

import android.app.Application
import android.content.Context
import java.lang.ref.WeakReference

/**
 * Created by rudenko.andrey on 10.05.2018.
 */
class CurrencyApp: Application() {
    companion object {
        private var context: WeakReference<Context>? = null

        fun getContext(): Context = context!!.get()!!
    }
}