package com.example.submission

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListAnimeAdapter(private val listAnime: ArrayList<Anime>) :
    RecyclerView.Adapter<ListAnimeAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_anime, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (rilis, name, genre, photo) = listAnime[position]
        holder.tvRilis.text = rilis
        holder.tvName.text = name
        holder.tvGenre.text = genre
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.imgPhoto)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listAnime[holder.adapterPosition]) }
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailAnime::class.java)
            intent.putExtra("EXTRA_ANIME", listAnime[holder.adapterPosition])
            holder.itemView.context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int = listAnime.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvGenre: TextView = itemView.findViewById(R.id.tv_item_genre)
        val tvRilis: TextView = itemView.findViewById(R.id.tv_rilis)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Anime)
    }



}