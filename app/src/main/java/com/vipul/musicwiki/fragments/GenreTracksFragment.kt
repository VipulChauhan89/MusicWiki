package com.vipul.musicwiki.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.vipul.musicwiki.MainViewModelFactory
import com.vipul.musicwiki.adapters.GenreTracksAdapter
import com.vipul.musicwiki.databinding.FragmentGenreTracksBinding
import com.vipul.musicwiki.repository.Repository
import com.vipul.musicwiki.viewmodel.MainViewModel


class GenreTracksFragment(var genreName: String) : Fragment() {

    private lateinit var binding: FragmentGenreTracksBinding
    private lateinit var genreTracksAdapter: GenreTracksAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGenreTracksBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getTagTopTracks(genreName.toString())
        viewModel.tagTopTracksResponse.observe(viewLifecycleOwner) { topTracks ->
            setupRecyclerView()
            genreTracksAdapter.genreTracks = topTracks
        }

        /*  lifecycleScope.launchWhenCreated {
              binding.tracksRvPb.isVisible = true
              val response1  = try {
                  RetrofitInstance.api.getTopTracks(genreName)
              }catch (e: IOException){
                  binding.tracksRvPb.isVisible = false
                  return@launchWhenCreated
              }catch (e : HttpException){
                  Log.d("TASG", "HttpException "+e)
                  binding.tracksRvPb.isVisible = false
                  return@launchWhenCreated
              }

              if(response1.isSuccessful && response1.body()!=null){
                  genreTracksAdapter.genreTracks = response1.body()!!.tracks.track
              }else{
                  Log.d("TASG", "Response not successful")
              }
              binding.tracksRvPb.isVisible = false
          }*/
    }

    private fun setupRecyclerView() = binding.tracksRv.apply {
        genreTracksAdapter = GenreTracksAdapter()
        adapter = genreTracksAdapter
        layoutManager = LinearLayoutManager(context)
    }
}