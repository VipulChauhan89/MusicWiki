package com.vipul.musicwiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.vipul.musicwiki.adapters.ViewPagerAdapter
import com.vipul.musicwiki.databinding.ActivityGenreInfoBinding
import com.vipul.musicwiki.dataclasses.TagX
import com.vipul.musicwiki.repository.Repository
import com.vipul.musicwiki.viewmodel.MainViewModel
import com.google.android.material.tabs.TabLayout

class GenreInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGenreInfoBinding
    lateinit var viewPagerAdapter: ViewPagerAdapter

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGenreInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ints = intent
        val name = ints.getStringExtra("NAME")

        viewPagerAdapter = ViewPagerAdapter(this, name.toString())
        binding.viewpager.adapter = viewPagerAdapter


        binding.tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewpager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        binding.viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tablayout.getTabAt(position)!!.select()
            }
        })

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getTagInfo(name.toString())
        viewModel.tagInfoResponse.observe(this) { info: TagX ->
            binding.genreTitle.text = info.name
            binding.genreDesc.text = info.wiki.summary
        }


        /*lifecycleScope.launchWhenCreated {
            binding.genreInfoPb.isVisible = true
            val response  = try {
                RetrofitInstance.api.getTagInfo(name.toString())
            }catch (e: IOException){
                Log.d("TASG", "IOException "+e)
                binding.genreInfoPb.isVisible = true
                return@launchWhenCreated
            }catch (e : HttpException){
                Log.d("TASG", "HttpException "+e)
                binding.genreInfoPb.isVisible = true
                return@launchWhenCreated
            }

            if(response.isSuccessful && response.body()!=null){
              binding.genreTitle.text = response.body()!!.tag.name
              binding.genreDesc.text = response.body()!!.tag.wiki.summary
            }else{
                Log.d("TASG", "Response not successful")
            }
            binding.genreInfoPb.isVisible = false
        }*/
    }
}