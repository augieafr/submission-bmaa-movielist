package com.augie.movielist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.augie.movielist.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener, View.OnClickListener,
    View.OnKeyListener {
    private lateinit var binding: ActivityMainBinding
    private var list = arrayListOf<Movie>()
    private val cardViewMovieAdapter = CardViewMovieAdapter(list)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list.addAll(MovieData.listData)

        // recycler view
        binding.rvMain.setHasFixedSize(true)
        showRecycler()

        // spinner
        binding.spinnerFilter.onItemSelectedListener = this

        // view

        binding.imgBtnAbout.setOnClickListener(this)
        binding.imgBtnReset.setOnClickListener(this)
        binding.edtSearch.setOnKeyListener(this)
    }

    private fun showRecycler(){
        binding.rvMain.layoutManager = LinearLayoutManager(this)
        binding.rvMain.adapter = cardViewMovieAdapter

        cardViewMovieAdapter.setOnItemClickCallback(object : CardViewMovieAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Movie) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_NAME, data.name)
                intent.putExtra(DetailActivity.EXTRA_SYSNOPSIS, data.synopsis)
                intent.putExtra(DetailActivity.EXTRA_GENRE, data.genre)
                intent.putExtra(DetailActivity.EXTRA_DATE, data.date)
                intent.putExtra(DetailActivity.EXTRA_BACKDROP, data.backdrop)
                intent.putExtra(DetailActivity.EXTRA_POSTER, data.poster)
                startActivity(intent)
            }

        })
    }

    private fun updateRecycler(newList: ArrayList<Movie>){
        list.clear()
        list.addAll(newList)
        if (list.isNullOrEmpty()) binding.tvNull.text = "Movie tidak ditemukan"
        cardViewMovieAdapter.notifyDataSetChanged()
    }

    private fun split(text:String):List<String>{
        val words = text.toLowerCase(Locale.ROOT).split("\\s+".toRegex()).map { word ->
            word.replace("""^[,\.]|[,\.]$""".toRegex(), "")
        }
        return words
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when(position){
            0 ->{
                val newList = MovieData.listData
                binding.tvNull.text = ""
                updateRecycler(newList)
            }

            1 ->{
                val list = MovieData.listData
                val newList = list.filter{"Action" in it.genre}
                updateRecycler(newList as ArrayList<Movie>)
            }

            2 ->{
                val list = MovieData.listData
                val newList = list.filter{"Drama" in it.genre}
                updateRecycler(newList as ArrayList<Movie>)
            }

            3 ->{
                val list = MovieData.listData
                val newList = list.filter {"Romance" in it.genre}
                updateRecycler(newList as ArrayList<Movie>)
            }

            4 ->{
                val list = MovieData.listData
                val newList = list.filter{"Comedy" in it.genre}
                updateRecycler(newList as ArrayList<Movie>)
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.imgBtn_reset ->{
                val newList = MovieData.listData
                updateRecycler(newList)
                binding.tvNull.text = ""
                binding.edtSearch.text.clear()
            }

            R.id.imgBtn_about ->{
                val intent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intent)
            }

        }
    }

    override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
        if((event?.action == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){
            when(v?.id){
                R.id.edt_search ->{
                    val text = binding.edtSearch.text.toString()
                    val newList = arrayListOf<Movie>()
                    for(index in 0 until list.size){
                        val words = split(list[index].name)
                        if(text.toLowerCase(Locale.ROOT) in words){
                            val newMovie = Movie()
                            newMovie.name = list[index].name
                            newMovie.genre = list[index].genre
                            newMovie.synopsis = list[index].synopsis
                            newMovie.date = list[index].date
                            newMovie.poster = list[index].poster
                            newMovie.backdrop = list[index].backdrop
                            newMovie.favorite = list[index].favorite
                            newList.add(newMovie)
                        }
                    }
                    updateRecycler(newList)
                }
            }
            return true
        } else return false
    }

}