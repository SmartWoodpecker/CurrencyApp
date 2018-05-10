package rudenko.andrey.currencyapp.mvpmodels

import rudenko.andrey.currencyapp.entity.Currencies
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import rudenko.andrey.currencyapp.api.RetrofitClient
import java.util.concurrent.TimeUnit

/**
 * Created by rudenko.andrey on 15.04.2018.
 */
class CurrencyImpl : CurrencyModel {
    override fun getAllCurrency(): Single<Currencies> {
        var response = RetrofitClient.testApiService.getAllCurrencyTe()
        response = response.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        return response
    }

    override fun startTimer(): Observable<Long> {
        var timer = Observable.interval(0, 1, TimeUnit.SECONDS).subscribeOn(Schedulers.io())
        timer = timer.take(16).map { v -> 15 - v }.observeOn(AndroidSchedulers.mainThread())
        return timer
    }
}