package com.augie.movielist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CardViewMovieAdapter(private val listMovie: ArrayList<Movie>): RecyclerView.Adapter<CardViewMovieAdapter.CardViewViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class CardViewViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_name)
        var tvGenre: TextView = itemView.findViewById(R.id.tv_genre)
        var imgBtnShare: ImageButton = itemView.findViewById(R.id.imgBtn_share)
        var imgBtnFavorite: ImageButton = itemView.findViewById(R.id.imgBtn_favorite)
        var imgPoster: ImageView = itemView.findViewById(R.id.img_poster)
        var imgBackdrop: ImageView = itemView.findViewById(R.id.img_backdrop)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview, parent, false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val movie = listMovie[position]

        holder.tvName.text = movie.name
        holder.tvGenre.text = movie.genre
        Glide.with(holder.itemView.context)
                .load(movie.poster)
                .into(holder.imgPoster)
        Glide.with(holder.itemView.context)
                .load(movie.backdrop)
                .into(holder.imgBackdrop)

        holder.imgBtnFavorite.setOnClickListener{
            if (listMovie[holder.adapterPosition].favorite){
                listMovie[holder.adapterPosition].favorite = false
                holder.imgBtnFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                Toast.makeText(holder.itemView.context, "Telah dihapus dari daftar favorit!", Toast.LENGTH_SHORT).show()
            } else {
                listMovie[holder.adapterPosition].favorite = true
                holder.imgBtnFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
                Toast.makeText(holder.itemView.context, "Telah ditambahkan ke daftar favorit!", Toast.LENGTH_SHORT).show()
            }
        }
        holder.imgBtnShare.setOnClickListener{
            Toast.makeText(holder.itemView.context, "Fitur belum tersedia", Toast.LENGTH_SHORT).show()
        }
        holder.itemView.setOnClickListener{ onItemClickCallback.onItemClicked(listMovie[holder.adapterPosition])}
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

    interface OnItemClickCallback{
        fun onItemClicked(data: Movie)
    }
}