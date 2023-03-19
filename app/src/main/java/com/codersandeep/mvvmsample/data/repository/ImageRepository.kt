package com.codersandeep.mvvmsample.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.codersandeep.mvvmsample.data.models.Image
import com.codersandeep.mvvmsample.data.network.ImageService

class ImageRepository(private val imageService: ImageService) {

    private val imageMutableLiveData = MutableLiveData<Image>()
    val images:LiveData<Image>
        get() = imageMutableLiveData

    suspend fun getImage(){
        val result = imageService.getImage();
        if (result.body()!=null)
            imageMutableLiveData.postValue(result.body())
    }
}