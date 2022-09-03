package com.ardian.moviearch.model

import com.ardian.moviearch.model.moviedetail.MovieDetailResponse
import com.ardian.moviearch.model.search.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Ardian Iqbal Yusmartito on 20/08/22
 * Github : https://github.com/ALU-syntax
 * Twitter : https://twitter.com/mengkerebe
 * Instagram : https://www.instagram.com/ardian_iqbal_
 * LinkedIn : https://www.linkedin.com/in/ardianiqbal
 */
interface Api {
    @GET("/")
    fun getMovies(
        @Query("s") s : String?,
        @Query("apikey") apikey : String
    ):Call<SearchResponse>

    @GET("/")
    fun getDetailMovies(
        @Query("i") i : String?,
        @Query("apikey") apikey: String
    ): Call<MovieDetailResponse>

}