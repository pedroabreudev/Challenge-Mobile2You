package br.com.pedroabreudev.desafio_mobile2you.service.model

import com.google.gson.annotations.SerializedName

data class SimilarMovieList(
    val resultsSimilarMovie: List<SimilarMovie>
)

data class SimilarMovie(

    @SerializedName("title")
    val title: String,

    @SerializedName("poster_path")
    val posterPath: String,

    @SerializedName("release_date")
    val releaseDate: String

)


