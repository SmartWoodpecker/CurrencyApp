package rudenko.andrey.currencyapp.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializer
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rudenko.andrey.currencyapp.BuildConfig
import java.util.*

/**
 * Created by rudenko.andrey on 09.05.2018.
 */
object RetrofitClient {
    var retrofit: Retrofit
    var gson: Gson
    private var httpClient: OkHttpClient
    var testApiService: MainApi

    init {
        gson = GsonBuilder().registerTypeAdapter(Date::class.java,
                JsonDeserializer { json, _, _ -> Date(json.asJsonPrimitive.asLong) })
                .setLenient().create()
        httpClient = OkHttpClient.Builder()
                .addInterceptor({ chain ->
                    val original: Request = chain.request()
                    val requestBuilder: Request.Builder = original.newBuilder()
                    val request = requestBuilder.build()
                    chain.proceed(request)
                })
                .addInterceptor(HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

        retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient)
                .build()
        testApiService = retrofit.create(MainApi::class.java)
    }
}