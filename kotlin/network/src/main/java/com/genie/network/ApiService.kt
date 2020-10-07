package com.genie.network

import com.genie.network.model.request.LoginBody
import com.genie.network.model.request.SignUpBody
import com.genie.network.model.respond.LoginResult
import com.genie.network.model.respond.SignUpResult
import com.genie.network.model.respond.WrapperRespond
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Created by viet.tr90@gmail.com on 2/8/20.
 */
interface ApiService{

    companion object {
        fun create(baseUrl: String): ApiService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }

    // User group
    @POST("customers/signup")
    fun signUp(@Body body: SignUpBody): Call<SignUpResult>

    @POST("customers/login")
    fun login(@Body body: LoginBody): Single<WrapperRespond<LoginResult>>

    // Movie group
    @GET("movies?api_key={api_key}")
    fun getMovieList(@Path("api_key") apiKey: String): Call<List<Any>>

    @GET("movie/popular?api_key={api_key}")
    fun getPopularMovies(@Path("api_key") apiKey: String): Call<List<Any>>

}