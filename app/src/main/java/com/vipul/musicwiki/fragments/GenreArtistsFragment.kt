package com.vipul.musicwiki.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.vipul.musicwiki.MainViewModelFactory
import com.vipul.musicwiki.adapters.GenreArtistsAdapter
import com.vipul.musicwiki.databinding.FragmentGenreArtistsBinding
import com.vipul.musicwiki.repository.Repository
import com.vipul.musicwiki.viewmodel.MainViewModel


class GenreArtistsFragment(var genreName: String) : Fragment() {

    private lateinit var binding: FragmentGenreArtistsBinding
    private lateinit var genreArtistsAdapter: GenreArtistsAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGenreArtistsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getTagTopArtists(genreName.toString())
        viewModel.tagTopArtistsResposne.observe(viewLifecycleOwner) { topArtists ->
            setupRecyclerView()
            genreArtistsAdapter.genreArtists = topArtists
        }

        /* lifecycleScope.launchWhenCreated {
             binding.artistsRvPb.isVisible = true
             val response  = try {
                 RetrofitInstance.api.getTopArtists(genreName)
             }catch (e: IOException){
                 binding.artistsRvPb.isVisible = false
                 return@launchWhenCreated
             }catch (e : HttpException){
                 Log.d("TASG", "HttpException "+e)
                 binding.artistsRvPb.isVisible = false
                 return@launchWhenCreated
             }

             if(response.isSuccessful && response.body()!=null){
                 genreArtistsAdapter.genreArtists = response.body()!!.topartists.artist
             }else{
                 Log.d("TASG", "Response not successful")
             }
             binding.artistsRvPb.isVisible = false
         }*/
    }

    private fun setupRecyclerView() = binding.artistsRv.apply {
        genreArtistsAdapter = GenreArtistsAdapter(context)
        adapter = genreArtistsAdapter
        layoutManager = LinearLayoutManager(context)
    }
}