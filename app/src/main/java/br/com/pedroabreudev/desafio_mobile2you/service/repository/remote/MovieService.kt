package br.com.pedroabreudev.desafio_mobile2you.service.repository.remote

import br.com.pedroabreudev.desafio_mobile2you.service.model.Movie
import br.com.pedroabreudev.desafio_mobile2you.service.model.SimilarMovieList
import retrofit2.Call
import retrofit2.http.GET

private const val api_key = "418fc16ab5943f1423c436aed898d978"
private const val movie_id = "249660"

interface MovieService {

    @GET("/movie/$movie_id?api_key=$api_key")
    fun getMovieDetails(): Call<Movie>

    @GET("movie/$movie_id/similar?api_key=$api_key")
    fun getSimilarMovie(): Call<SimilarMovieList>


}