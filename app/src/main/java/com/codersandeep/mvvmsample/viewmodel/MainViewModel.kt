package com.codersandeep.databindingexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codersandeep.mvvmsample.data.models.Image
import com.codersandeep.mvvmsample.data.repository.ImageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val imageRepository: ImageRepository): ViewModel() {
    init {
       getNext()
    }
    val images:LiveData<Image>
    get() = imageRepository.images

    private fun getNext(){
        viewModelScope.launch(Dispatchers.IO) {
            imageRepository.getImage()
        }
    }
}