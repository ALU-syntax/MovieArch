package com.ardian.moviearch.model.search.data

import com.google.gson.annotations.SerializedName


/**
 * Created by Ardian Iqbal Yusmartito on 19/08/22
 * Github : https://github.com/ALU-syntax
 * Twitter : https://twitter.com/mengkerebe
 * Instagram : https://www.instagram.com/ardian_iqbal_
 * LinkedIn : https://www.linkedin.com/in/ardianiqbal
 */
data class MovieData(
    @SerializedName("Year") val year :String,
    @SerializedName("Title") val title : String,
    @SerializedName("Poster") val gambar : String,
    @SerializedName("imdbID") val idMovie : String
)