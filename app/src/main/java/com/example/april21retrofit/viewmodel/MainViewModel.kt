package com.example.april21retrofit.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.april21retrofit.api.Api
import com.example.april21retrofit.api.RetrofitHelper
import com.example.april21retrofit.model.Photos
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val photosMutableData = MutableLiveData<Photos>()
    val photoLiveData = photosMutableData

    init {
        getPhotosData()
    }

    private fun getPhotosData() {
        viewModelScope.launch {
            val result = RetrofitHelper.getInstance().create(Api::class.java).getPhotos()
            if (result.isSuccessful) {
                photosMutableData.value = result.body()
            }
        }

    }
}
