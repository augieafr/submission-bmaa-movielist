package com.augie.movielist

import android.os.Binder
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.augie.movielist.databinding.ActivityDetailBinding
import com.augie.movielist.databinding.ContentDetailBinding
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_SYSNOPSIS = "extra_synopsis"
        const val EXTRA_POSTER = "extra_poster"
        const val EXTRA_BACKDROP = "extra_backdrop"
        const val EXTRA_DATE = "extra_date"
        const val EXTRA_GENRE = "extra_genre"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(EXTRA_NAME)
        val synopsis = intent.getStringExtra(EXTRA_SYSNOPSIS)
        val genre = intent.getStringExtra(EXTRA_GENRE)
        val date = intent.getStringExtra(EXTRA_DATE)
        val poster = intent.getIntExtra(EXTRA_POSTER, 0)
        val backdrop = intent.getIntExtra(EXTRA_BACKDROP, 0)

        binding.tvTitleDetail.text = name
        binding.tvSynopsisDetail.text = synopsis
        binding.tvGenreDetail.text = genre
        binding.tvDateDetail.text = date

        Glide.with(this)
            .load(poster)
            .into(binding.imgPosterPhotoDetail)

        Glide.with(this)
            .load(backdrop)
            .into(binding.imgBackdropPhotoDetail)
    }
}