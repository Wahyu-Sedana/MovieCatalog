package com.example.movieapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.models.TvResponse
import kotlinx.android.synthetic.main.movie_row_item.view.*

class TvAdapter(
    private val tvs : List<TvResponse>
) : RecyclerView.Adapter<TvAdapter.TvViewHolder>(){

    class TvViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(tv : TvResponse){
            itemView.movie_title.text = tv.name
            itemView.movie_release_date.text = tv.firstAirDate
            itemView.popularity.text = tv.popularity
            itemView.language.text = tv.originalLanguage
            Glide.with(itemView).load(IMAGE_BASE + tv.posterPath).into(itemView.movie_poster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        return TvViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_row_item, parent, false)
        )
    }

    override fun getItemCount(): Int = tvs.size

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        holder.bindMovie(tvs.get(position))
    }
}