package rudenko.andrey.currencyapp.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by rudenko.andrey on 09.05.2018.
 */
data class CurrencyEntity (
        @SerializedName("name")
        val name: String?,
        @SerializedName("price")
        val price: PriceEntity?,
        @SerializedName("percent_change")
        val percent_change: String?,
        @SerializedName("volume")
        val volume: Int?,
        @SerializedName("symbol")
        val symbol: String?
)
