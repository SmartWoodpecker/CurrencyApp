package rudenko.andrey.currencyapp.presentation.currency

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import rudenko.andrey.currencyapp.entity.CurrencyEntity


/**
 * Created by rudenko.andrey on 09.05.2018.
 */
interface CurrencyView : MvpView {

    fun addCurrencysToList(proposals: ArrayList<CurrencyEntity>)
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showRefreshing()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun hideRefreshing()

    @StateStrategyType(SkipStrategy::class)
    fun showProgressBar()

    @StateStrategyType(SkipStrategy::class)
    fun hideProgressBar()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showConnectionError()

    @StateStrategyType(SkipStrategy::class)
    fun refreshCurrrencyList()
}