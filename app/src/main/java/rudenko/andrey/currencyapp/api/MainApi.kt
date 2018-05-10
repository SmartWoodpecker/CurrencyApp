package rudenko.andrey.currencyapp.api


import rudenko.andrey.currencyapp.entity.Currencies
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by rudenko.andrey on 09.05.2018.
 */
interface MainApi {
    @GET("stocks.json")
    fun getAllCurrencyTe(): Single<Currencies>
}