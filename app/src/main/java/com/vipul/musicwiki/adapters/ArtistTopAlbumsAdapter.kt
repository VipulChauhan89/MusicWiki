package com.vipul.musicwiki.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vipul.musicwiki.AlbumInfoActivity
import com.vipul.musicwiki.databinding.CardItemBinding
import com.vipul.musicwiki.dataclasses.AlbumXXX
import com.vipul.musicwiki.loadImage

class ArtistTopAlbumsAdapter(var mContext: Context) :
    RecyclerView.Adapter<ArtistTopAlbumsAdapter.ArtistTopAlbumsViewHolder>() {
    inner class ArtistTopAlbumsViewHolder(val binding: CardItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    var artistTopAlbums: List<AlbumXXX> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistTopAlbumsViewHolder {
        return ArtistTopAlbumsViewHolder(
            CardItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ArtistTopAlbumsViewHolder, position: Int) {
        holder.binding.apply {
            itemTitle.text = artistTopAlbums[position].name
            itemArtistName.text = artistTopAlbums[position].artist.name
            itemImg.loadImage(artistTopAlbums[position].image[0].text)
        }
        holder.binding.root.setOnClickListener {
            val mIntent = Intent(mContext, AlbumInfoActivity::class.java)
            mIntent.putExtra("ANAME", artistTopAlbums[position].name)
            mIntent.putExtra("ARNAME", artistTopAlbums[position].artist.name)
            mContext.startActivity(mIntent)
        }
    }

    override fun getItemCount(): Int {
        return artistTopAlbums.size
    }
}

