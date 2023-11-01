package com.example.submission

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailAnime : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_anime)

        val anime = intent.getParcelableExtra<Anime>("EXTRA_ANIME")

        val imgPhoto = findViewById<ImageView>(R.id.img_item_photo)
        val tvName = findViewById<TextView>(R.id.tv_item_name)
        val tvGenre = findViewById<TextView>(R.id.tv_genre)
        val tvRilis = findViewById<TextView>(R.id.tv_rilis)
        val tvSutradara = findViewById<TextView>(R.id.tv_sutradara)
        val tvSinopsis = findViewById<TextView>(R.id.tv_sinopsis)

        if (anime != null) {
            Glide.with(this)
                .load(anime.photo)
                .into(imgPhoto)
            tvName.text = anime.name
            tvGenre.text = anime.genre
            tvRilis.text = anime.rilis
            tvSutradara.text = anime.sutradara
            tvSinopsis.text = anime.sinopsis
        }
    }
}
