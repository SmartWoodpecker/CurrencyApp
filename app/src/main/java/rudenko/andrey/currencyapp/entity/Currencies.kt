package rudenko.andrey.currencyapp.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by rudenko.andrey on 09.05.2018.
 */
data class Currencies(
    @SerializedName("stock")
    val stock: ArrayList<CurrencyEntity>
)