package com.vipul.musicwiki.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.vipul.musicwiki.MainViewModelFactory
import com.vipul.musicwiki.adapters.GenreAlbumsAdapter
import com.vipul.musicwiki.databinding.FragmentGenreAlbumsBinding
import com.vipul.musicwiki.repository.Repository
import com.vipul.musicwiki.viewmodel.MainViewModel


class GenreAlbumsFragment(var genreName: String) : Fragment() {

    private lateinit var binding: FragmentGenreAlbumsBinding
    private lateinit var genreAlbumsAdapter: GenreAlbumsAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGenreAlbumsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getTagTopAlbums(genreName.toString())
        viewModel.tagTopAlbumsResponse.observe(viewLifecycleOwner) { topAlbums ->
            setupRecyclerView()
            genreAlbumsAdapter.genreAlbums = topAlbums
        }

        /* lifecycleScope.launchWhenCreated {
             binding.albumsRvPb.isVisible = true
             val response  = try {
                 RetrofitInstance.api.getTopAlbums(genreName)
             }catch (e: IOException){
                 binding.albumsRvPb.isVisible = false
                 return@launchWhenCreated
             }catch (e : HttpException){
                 Log.d("TASG", "HttpException "+e)
                 binding.albumsRvPb.isVisible = false
                 return@launchWhenCreated
             }

             if(response.isSuccessful && response.body()!=null){
                 genreAlbumsAdapter.genreAlbums = response.body()!!.albums.album
             }else{
                 Log.d("TASG", "Response not successful")
             }
             binding.albumsRvPb.isVisible = false
         }*/
    }

    private fun setupRecyclerView() = binding.albumsRv.apply {
        genreAlbumsAdapter = GenreAlbumsAdapter(context)
        adapter = genreAlbumsAdapter
        layoutManager = LinearLayoutManager(context)
    }
}