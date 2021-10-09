package br.com.pedroabreudev.desafio_mobile2you.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.pedroabreudev.desafio_mobile2you.R
import br.com.pedroabreudev.desafio_mobile2you.service.model.SimilarMovie
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_item.view.*
import java.text.SimpleDateFormat
import java.util.*

class SimilarAdapter (private val movies: List<SimilarMovie>) :
        RecyclerView.Adapter<SimilarAdapter.MovieViewHolder>() {

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(movie: SimilarMovie){

            itemView.titleCard_Movie.text = movie.title
            var date = movie.releaseDate
            var spf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val newDate = spf.parse(date)
            spf = SimpleDateFormat("yyyy", Locale.getDefault())
            date = spf.format(newDate)
            itemView.textCardYear_Movie.text = date

            //itemView.textCardGenres_Movie.text = movie.genres
            Glide.with(itemView).load(IMAGE_BASE + movie.posterPath).into(itemView.imageCard_Movie)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies[position])
    }

    override fun getItemCount(): Int = movies.size

}