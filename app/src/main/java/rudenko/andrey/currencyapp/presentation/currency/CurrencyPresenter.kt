package com.example.rudenkoandrey.tesapp.data.presentation.currency

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import rudenko.andrey.currencyapp.mvpmodels.CurrencyImpl
import io.reactivex.observers.DisposableObserver
import io.reactivex.rxkotlin.subscribeBy
import rudenko.andrey.currencyapp.mvpmodels.CurrencyModel
import rudenko.andrey.currencyapp.presentation.currency.CurrencyView

/**
 * Created by rudenko.andrey on 09.05.2018.
 */
@InjectViewState
class CurrencyPresenter : MvpPresenter<CurrencyView>() {

    private val currencyModel: CurrencyModel = CurrencyImpl()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getCurrency(true)
    }

    fun getCurrency(isFirstLaunchTimer: Boolean) {
        currencyModel.getAllCurrency()
                .doAfterTerminate({
                    viewState.hideRefreshing()
                    viewState.hideProgressBar()
                })
                .subscribeBy(
                        onSuccess = {
                            viewState.addCurrencysToList(it.stock)
                            if (isFirstLaunchTimer) {
                                runTimer()
                            }
                        },
                        onError = {
                            viewState.showConnectionError()
                        }
                )
    }

    private fun runTimer() {
        currencyModel.startTimer().subscribe(object : DisposableObserver<Long>() {
            override fun onNext(t: Long) {}

            override fun onComplete() {
                viewState.showProgressBar()
                getCurrency(true)
            }

            override fun onError(e: Throwable) {}
        })
    }

    fun currencyRefreshed() {
        viewState.showRefreshing()
        viewState.refreshCurrrencyList()
    }
}