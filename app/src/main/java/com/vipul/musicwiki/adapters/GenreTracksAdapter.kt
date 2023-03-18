package com.vipul.musicwiki.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vipul.musicwiki.databinding.CardItemBinding
import com.vipul.musicwiki.dataclasses.Track
import com.vipul.musicwiki.loadImage

class GenreTracksAdapter : RecyclerView.Adapter<GenreTracksAdapter.GenreTracksViewHolder>() {
    inner class GenreTracksViewHolder(val binding: CardItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    var genreTracks: List<Track> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreTracksViewHolder {
        return GenreTracksViewHolder(
            CardItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GenreTracksViewHolder, position: Int) {
        holder.binding.apply {
            itemTitle.text = genreTracks[position].name
            itemArtistName.text = genreTracks[position].artist.name
            itemImg.loadImage(genreTracks[position].image[0].text)
        }
    }

    override fun getItemCount(): Int {
        return genreTracks.size
    }
}