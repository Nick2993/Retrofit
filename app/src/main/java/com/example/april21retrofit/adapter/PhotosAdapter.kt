package com.example.april21retrofit.adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.april21retrofit.R
import com.example.april21retrofit.model.PhotosItem

class PhotosAdapter(private val data: List<PhotosItem>) :
    RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {
    class PhotosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val photosImage: ImageView = itemView.findViewById(R.id.photoImage)
        private val photosId: TextView = itemView.findViewById(R.id.photoID)
        private val photosTitle: TextView = itemView.findViewById(R.id.photoTitle)

        fun bind(photosItem: PhotosItem) {
            // Load image using Glide
            Glide.with(itemView)
                .load(photosItem.url) // Replace imageUrl with your actual image URL field
                .into(photosImage)
            photosId.text = photosItem.id.toString()
            photosTitle.text = photosItem.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photos_item, parent, false)
        return PhotosViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        holder.bind(data[position])
    }
}