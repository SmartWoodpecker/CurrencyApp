package rudenko.andrey.currencyapp.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by rudenko.andrey on 09.05.2018.
 */
data class PriceEntity(
        @SerializedName("currency")
        val name: String?,
        @SerializedName("amount")
        val amount: Double?
)