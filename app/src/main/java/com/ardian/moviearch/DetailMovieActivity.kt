package com.ardian.moviearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ardian.moviearch.databinding.ActivityDetailMovieBinding
import com.ardian.moviearch.model.RClient
import com.ardian.moviearch.model.moviedetail.MovieDetailResponse
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailMovieActivity : AppCompatActivity() {

    private lateinit var  binding : ActivityDetailMovieBinding
    var b : Bundle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        b = intent.extras
        val i = b?.getString("imdbid")
        val apikey = "bb8d10c9"

        RClient.instance.getDetailMovies(i, apikey).enqueue(object : Callback<MovieDetailResponse>{
            override fun onResponse(
                call: Call<MovieDetailResponse>,
                response: Response<MovieDetailResponse>
            ) {
                binding.tvTitle.text = response.body()?.title
                binding.tvDuration.text = response.body()?.runtime
                binding.tvReleased.text = response.body()?.released
                binding.tvGenre.text = response.body()?.genre
                binding.tvRated.text = response.body()?.rated
                binding.tvRating.text = response.body()?.rating
                binding.tvPlot.text = "Plot : ${response.body()?.plot}"
                binding.tvDirector.text = "Director : ${response.body()?.director}"
                binding.tvActor.text = "Actor : ${response.body()?.actor}"
                binding.tvWriter.text = "Writer : ${response.body()?.writer}"
                Glide.with(this@DetailMovieActivity).load(response.body()?.gambar).into(binding.ivPoster)
            }
            override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}