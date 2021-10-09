package br.com.pedroabreudev.desafio_mobile2you.service.model

import com.google.gson.annotations.SerializedName

data class Movie(

    @SerializedName("title")
    val title: String,

    @SerializedName("poster_path")
    val posterPatch: String,

    @SerializedName("release_date")
    val releaseDate: String,

    @SerializedName("backdrop_path")
    val backdropPath: String,

    @SerializedName("vote_count")
    val likes: String,

    @SerializedName("popularity")
    val popularity: String

)
