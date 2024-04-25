package com.example.april21retrofit.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.april21retrofit.api.Api
import com.example.april21retrofit.api.RetrofitHelper
import androidx.lifecycle.viewModelScope
import com.example.april21retrofit.model.PhotosItem
import com.example.april21retrofit.room.PhotosItemDatabase
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    //
//    private val photosMutableData = MutableLiveData<Photos>()
//    val photoLiveData = photosMutableData
    private val photosDao = PhotosItemDatabase.getDatabase(application).getPhotosItemDao()
    val photosMutableData: LiveData<List<PhotosItem>> = photosDao.getAllPhotos()

    init {
        getPhotosData()
    }

    private fun getPhotosData() {
        viewModelScope.launch {
            val result = RetrofitHelper.getInstance().create(Api::class.java).getPhotos()
            if (result.isSuccessful) {
               // photosMutableData.value = result.body()
                result.body()?.let {
                    photosDao.insert(it)
                }
            }
        }

    }
}
