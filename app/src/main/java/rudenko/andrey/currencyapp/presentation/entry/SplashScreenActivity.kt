package rudenko.andrey.currencyapp.presentation.entry

import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import rudenko.andrey.currencyapp.presentation.currency.CurrencyActivity

/**
 * Created by rudenko.andrey on 15.04.2018.
 */
class SplashScreenActivity : MvpAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(Intent(this, CurrencyActivity::class.java))
        finish()
    }
}