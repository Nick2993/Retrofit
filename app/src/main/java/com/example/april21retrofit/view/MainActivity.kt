package com.example.april21retrofit.view

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.april21retrofit.R
import com.example.april21retrofit.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.photoLiveData.observe(this) {
            Log.d("PHOTOS DATA", it.toString())
        }
    }
}