package co.android.wframadhan.techtest.utils

import android.content.Context
import co.android.wframadhan.techtest.services.ApiClient
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceGenerator(private val context: Context, private val gson: Gson) {

    private val okHttpBuilder = OkHttpClient.Builder()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun <S> createService(
        serviceClass: Class<S>,
        baseUrl: String
    ): S {

        val client = okHttpBuilder.build()
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(serviceClass)
    }
}