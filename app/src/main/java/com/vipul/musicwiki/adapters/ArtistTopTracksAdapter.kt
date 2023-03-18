package com.vipul.musicwiki.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vipul.musicwiki.databinding.CardItemBinding
import com.vipul.musicwiki.dataclasses.TrackXX
import com.vipul.musicwiki.loadImage

class ArtistTopTracksAdapter :
    RecyclerView.Adapter<ArtistTopTracksAdapter.AristTopTracksViewHolder>() {
    inner class AristTopTracksViewHolder(val binding: CardItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    var artistInfoTopTracks: List<TrackXX> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AristTopTracksViewHolder {
        return AristTopTracksViewHolder(
            CardItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AristTopTracksViewHolder, position: Int) {
        holder.binding.apply {
            itemTitle.text = artistInfoTopTracks[position].name
            itemArtistName.text = artistInfoTopTracks[position].artist.name
            itemImg.loadImage(artistInfoTopTracks[position].image[0].text)
        }
    }

    override fun getItemCount(): Int {
        return artistInfoTopTracks.size
    }
}
