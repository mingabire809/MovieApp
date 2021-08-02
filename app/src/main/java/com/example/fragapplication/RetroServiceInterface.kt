package com.demo.countrylistretrofit.retrofit

import com.example.fragapplication.MovieModel
import retrofit2.Call
import retrofit2.http.*

interface RetroServiceInterface {
    //CREATE
    @POST("addmovie.php/")
    @FormUrlEncoded
    fun addMovie(
        @Field("title") title: String,
        @Field("des") des: String,
        @Field("image") image: String
    ): Call<List<MovieModel>>

    //READ
    @GET("allmovies.php/")
    fun getMovieList(): Call<List<MovieModel>>

    //UPDATE
    @POST("updatemovie.php/")
    @FormUrlEncoded
    fun updateMovie(
        @Field("title") title: String,
        @Field("des") des: String,
    ): Call<List<MovieModel>>

    //DELETE
    @POST("deletemovie.php/")
    @FormUrlEncoded
    fun deleteMovie(
        @Field("title") title: String,
    ): Call<List<MovieModel>>


}