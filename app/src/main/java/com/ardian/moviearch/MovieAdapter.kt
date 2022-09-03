package com.ardian.moviearch

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ardian.moviearch.databinding.ListDatamovieBinding
import com.ardian.moviearch.model.search.data.MovieData
import com.bumptech.glide.Glide
/**
 * Created by Ardian Iqbal Yusmartito on 20/08/22
 * Github : https://github.com/ALU-syntax
 * Twitter : https://twitter.com/mengkerebe
 * Instagram : https://www.instagram.com/ardian_iqbal_
 * LinkedIn : https://www.linkedin.com/in/ardianiqbal
 */
class MovieAdapter(
    private val listMovie : ArrayList<MovieData>,
    private val context : Context
) : RecyclerView.Adapter<MovieAdapter.Holder>() {

    inner class Holder(itemView: ListDatamovieBinding) : RecyclerView.ViewHolder(itemView.root) {
        private val binding = itemView
        fun bind(movieData : MovieData){
            with(binding){
                Glide.with(itemView).load(movieData.gambar).into(ivPoster)
                tvTitle.text = movieData.title
                tvYear.text = movieData.year

                cvIdMovie.setOnClickListener{
                    var i = Intent(context, DetailMovieActivity::class.java).apply {
                        putExtra("imdbid", movieData.idMovie)
                    }
                    context.startActivity(i)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ListDatamovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(listMovie[position])
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }
}