package com.vipul.musicwiki.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.vipul.musicwiki.GenreInfoActivity
import com.vipul.musicwiki.databinding.GenreItemBinding
import com.vipul.musicwiki.dataclasses.Tag

class TopGenreAdapter(var mContext: Context) :
    RecyclerView.Adapter<TopGenreAdapter.TopGenreViewHolder>() {

    public var isExpanded: Boolean = false

    inner class TopGenreViewHolder(val binding: GenreItemBinding) :
        RecyclerView.ViewHolder(binding.root)


    var genres: List<Tag> = arrayListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopGenreViewHolder {
        return TopGenreViewHolder(
            GenreItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TopGenreViewHolder, position: Int) {
        holder.binding.apply {
            val genre = genres[position]
            genreName.text = genres[position].name
        }
        holder.binding.root.setOnClickListener {
            val mIntent = Intent(mContext, GenreInfoActivity::class.java)
            mIntent.putExtra("NAME", genres[position].name)
            mContext.startActivity(mIntent)
        }
    }

    override fun getItemCount(): Int {
        return if (isExpanded) {
            genres.size
        } else {
            10.coerceAtMost(genres.size)
        }
    }
}
