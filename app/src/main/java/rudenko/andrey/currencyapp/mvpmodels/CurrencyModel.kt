package rudenko.andrey.currencyapp.mvpmodels

import rudenko.andrey.currencyapp.entity.Currencies
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by rudenko.andrey on 15.04.2018.
 */
interface CurrencyModel {
    fun getAllCurrency(): Single<Currencies>
    fun startTimer(): Observable<Long>
}