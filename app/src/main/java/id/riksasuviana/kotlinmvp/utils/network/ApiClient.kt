package id.riksasuviana.kotlinmvp.utils.network

import id.riksasuviana.kotlinmvp.utils.Network
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * Created by riksa on 28/01/2018.
 */
class ApiClient {
    companion object {
        lateinit var mRetrofit: Retrofit
        fun request(): Retrofit {
            var loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            var client = OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .readTimeout(300, TimeUnit.SECONDS)
                    .connectTimeout(300, TimeUnit.SECONDS)
                    .build()

            mRetrofit = Retrofit.Builder()
                    .baseUrl(Network.API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(client)
                    .build()

            return mRetrofit
        }
    }
}