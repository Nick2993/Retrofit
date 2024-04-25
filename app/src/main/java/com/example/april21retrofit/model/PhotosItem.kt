package com.example.april21retrofit.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photos_table")
data class PhotosItem(
    val albumId: Int,
    @PrimaryKey
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)