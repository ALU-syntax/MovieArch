package com.ardian.moviearch.model.moviedetail

import com.google.gson.annotations.SerializedName


/**
 * Created by Ardian Iqbal Yusmartito on 19/08/22
 * Github : https://github.com/ALU-syntax
 * Twitter : https://twitter.com/mengkerebe
 * Instagram : https://www.instagram.com/ardian_iqbal_
 * LinkedIn : https://www.linkedin.com/in/ardianiqbal
 */
data class MovieDetailResponse(
    @SerializedName("Title") val title : String,
    @SerializedName("Rated") val rated : String,
    @SerializedName("Released") val released : String,
    @SerializedName("Runtime") val runtime : String,
    @SerializedName("Genre") val genre : String,
    @SerializedName("imdbRating") val rating : String,
    @SerializedName("Plot") val plot : String,
    @SerializedName("Director") val director : String,
    @SerializedName("Actors") val actor : String,
    @SerializedName("Writer") val writer : String,
    @SerializedName("Poster") val gambar : String
    )
