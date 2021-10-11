package br.com.pedroabreudev.desafio_mobile2you

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.pedroabreudev.desafio_mobile2you.service.model.Movie
import br.com.pedroabreudev.desafio_mobile2you.service.model.SimilarMovie
import br.com.pedroabreudev.desafio_mobile2you.service.model.SimilarMovieList
import br.com.pedroabreudev.desafio_mobile2you.service.repository.remote.MovieService
import br.com.pedroabreudev.desafio_mobile2you.service.repository.remote.RetrofitClient
import br.com.pedroabreudev.desafio_mobile2you.view.adapter.SimilarAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val BASE_URL_IMAGE = "https://image.tmdb.org/t/p/original/"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView_Movie.layoutManager = LinearLayoutManager(this)
        recyclerView_Movie.setHasFixedSize(true)
        getSimilarMovieData { movies: List<SimilarMovie> ->
            recyclerView_Movie.adapter = SimilarAdapter(movies)

        }
    }

    private fun getSimilarMovieData(callback: (List<SimilarMovie>) -> Unit) {
        val apiService = RetrofitClient.getInstance().create(MovieService::class.java)
        apiService.getSimilarMovie().enqueue(object : Callback<SimilarMovieList> {
            override fun onResponse(
                call: Call<SimilarMovieList>,
                response: Response<SimilarMovieList>
            ) {
                return callback(response.body()!!.results)
            }

            override fun onFailure(call: Call<SimilarMovieList>, t: Throwable) {
            }
        })
    }
}