package com.codersandeep.mvvmsample.data.models

data class Image(
    val `file`: String,
    val filter: String,
    val height: Int,
    val license: String,
    val owner: String,
    val tagMode: String,
    val tags: String,
    val width: Double
)