package com.genie.network

import com.genie.network.model.request.LoginBody
import com.genie.network.model.request.SignUpBody
import com.genie.network.model.respond.LoginResult
import com.genie.network.model.respond.SignUpResult
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Created by viet.tr90@gmail.com on 2/8/20.
 */
interface ApiService{

    // User group
    @POST("customers/signup")
    fun signUp(@Body body: SignUpBody): Call<SignUpResult>

    @POST("customers/login")
    fun login(@Body body: LoginBody): Call<LoginResult>

    // Movie group
    @GET("movies?api_key={api_key}")
    fun getMovieList(@Path("api_key") apiKey: String): Call<List<Any>>

    @GET("movie/popular?api_key={api_key}")
    fun getPopularMovies(@Path("api_key") apiKey: String): Call<List<Any>>

}