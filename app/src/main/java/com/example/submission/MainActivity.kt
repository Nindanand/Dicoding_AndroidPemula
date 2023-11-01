package com.example.submission


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvAnimes: RecyclerView
    private val list = ArrayList<Anime>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvAnimes = findViewById(R.id.rv_anime)
        rvAnimes.setHasFixedSize(true)
        list.addAll(getListAnime())
        showRecyclerList()
    }

    private fun getListAnime(): ArrayList<Anime> {
        val dataGenre = resources.getStringArray(R.array.data_genre)
        val dataName = resources.getStringArray(R.array.data_name)
        val dataRilis = resources.getStringArray(R.array.data_rilis)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataSutradara = resources.getStringArray(R.array.data_sutradara)
        val dataSinopsis = resources.getStringArray(R.array.data_sinopsis)
        val listAnime = ArrayList<Anime>()
        for (i in dataName.indices) {
            val anime = Anime(dataRilis[i], dataName[i], dataGenre[i], dataPhoto.getResourceId(i, -1), dataSutradara[i], dataSinopsis[i])
            listAnime.add(anime)
        }
        return listAnime
    }

    private fun showRecyclerList() {
        rvAnimes.layoutManager = LinearLayoutManager(this)
        val listAnimeAdapter = ListAnimeAdapter(list)
        rvAnimes.adapter = listAnimeAdapter

        listAnimeAdapter.setOnItemClickCallback(object : ListAnimeAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Anime) {
                showSelectedAnime(data)
            }
        })
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    private fun showSelectedAnime(hero: Anime) {
        Toast.makeText(this, "Kamu memilih " + hero.name, Toast.LENGTH_SHORT).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}