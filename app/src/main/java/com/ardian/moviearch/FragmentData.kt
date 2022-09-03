package com.ardian.moviearch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.ardian.moviearch.model.RClient
import com.ardian.moviearch.databinding.FragmentDataBinding
import com.ardian.moviearch.model.search.data.MovieData
import com.ardian.moviearch.model.search.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentData : Fragment() {
    private var _binding: FragmentDataBinding? = null
    private val binding get() = _binding!!
    private val list = ArrayList<MovieData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDataBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvData.setHasFixedSize(true)
        binding.rvData.layoutManager = GridLayoutManager(context,2)
        val bundle = arguments
        val s = bundle?.getString("carimovie")
        val apikey = "bb8d10c9"

        binding.progressBar.visibility


        RClient.instance.getMovies(s, apikey).enqueue(object : Callback<SearchResponse> {
            override fun onResponse(call: Call<SearchResponse>, response: Response<SearchResponse>) {
//                val responseCode = response.code()
                val cekRes = response.body()?.res

                if (cekRes == "True"){
                    response.body()?.let { list.addAll(it.data) }
                    val adapter = MovieAdapter(list, requireContext())
                    binding.rvData.adapter = adapter
                    binding.progressBar.isVisible = false
                }else{
                    Toast.makeText(context, "Movie Not Found", Toast.LENGTH_LONG).show()
                    binding.progressBar.isVisible = false
                }


            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {

            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}