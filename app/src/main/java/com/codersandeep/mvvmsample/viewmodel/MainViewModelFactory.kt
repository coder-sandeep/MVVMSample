package com.codersandeep.mvvmsample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.codersandeep.databindingexample.viewmodel.MainViewModel
import com.codersandeep.mvvmsample.data.repository.ImageRepository

class MainViewModelFactory(private val imageRepository: ImageRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(imageRepository) as T
    }
}