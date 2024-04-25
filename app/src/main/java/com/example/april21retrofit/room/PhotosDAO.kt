package com.example.april21retrofit.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.april21retrofit.model.PhotosItem

@Dao
interface PhotosDAO {
    @Insert
    suspend fun insert(photosItem: List<PhotosItem>)

    @Query("SELECT * FROM PHOTOS_TABLE ")
    fun getAllPhotos(): LiveData<List<PhotosItem>>
}