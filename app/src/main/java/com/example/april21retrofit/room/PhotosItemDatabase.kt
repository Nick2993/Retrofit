package com.example.april21retrofit.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.april21retrofit.model.PhotosItem

@Database(entities = [PhotosItem::class], version = 1)
abstract class PhotosItemDatabase : RoomDatabase() {
    abstract fun getPhotosItemDao(): PhotosDAO

    companion object {
        @Volatile
        private var INSTANCE: PhotosItemDatabase? = null

        fun getDatabase(context: Context): PhotosItemDatabase {
           return INSTANCE?: synchronized(this){
               val instance = Room.databaseBuilder(context.applicationContext,
                   PhotosItemDatabase::class.java,
                   "photos_item_database")
                   .build()
               INSTANCE = instance
               instance
           }

        }


    }


}