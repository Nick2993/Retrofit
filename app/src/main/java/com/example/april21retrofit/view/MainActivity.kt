package com.example.april21retrofit.view

import android.os.Bundle
import android.provider.ContactsContract.Contacts.Photo
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.april21retrofit.R
import com.example.april21retrofit.adapter.PhotosAdapter
import com.example.april21retrofit.databinding.ActivityMainBinding
import com.example.april21retrofit.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: PhotosAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.photosMutableData.observe(this) { photos ->
            Log.d("PHOTOS DATA", photos.toString())
            adapter = PhotosAdapter(photos)
            binding.recyclerViewMain.adapter = adapter
            binding.recyclerViewMain.layoutManager = LinearLayoutManager(this)


        }
    }
}