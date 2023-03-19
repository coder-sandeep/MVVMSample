package com.codersandeep.mvvmsample.data.network

import com.codersandeep.mvvmsample.data.models.Image
import retrofit2.Response
import retrofit2.http.GET

interface ImageService {
    @GET("/json/g/768/1366/nature/all")
    suspend fun getImage(
    ): Response<Image>
}