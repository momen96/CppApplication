package services

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object serviceBuilder {

    val URL = "http://192.168.1.6/app/public/api/"

    val okHttp = OkHttpClient.Builder()

    val builder = Retrofit.Builder().baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())

    val retrofit = builder.build()

    fun <T> buildService (serviceType : Class<T>) : T {
        return retrofit.create(serviceType)
    }

}