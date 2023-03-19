package com.codersandeep.mvvmsample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.codersandeep.mvvmsample.data.network.ImageService
import com.codersandeep.mvvmsample.data.network.RetrofitHelper
import com.codersandeep.mvvmsample.data.repository.ImageRepository
import com.codersandeep.mvvmsample.utils.Constants.BASE_URL
import com.codersandeep.databindingexample.viewmodel.MainViewModel
import com.codersandeep.mvvmsample.viewmodel.MainViewModelFactory
import com.codersandeep.mvvmsample.R
import com.codersandeep.mvvmsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var homeViewModel: MainViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        setUpMVVM()
    }

    private fun setUpMVVM() {
        val imageService = RetrofitHelper.getInstance(BASE_URL)
            .create(ImageService::class.java)
        val imageRepository = ImageRepository(imageService)

        homeViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(imageRepository)
        )[MainViewModel::class.java]

        homeViewModel.images.observe(this) {
            binding.imageItem = it
        }
    }
}