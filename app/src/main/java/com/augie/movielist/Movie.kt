package com.augie.movielist

data class Movie(var name: String = "", var synopsis: String = "", var poster: Int = 0,
                 var backdrop: Int= 0, var genre: String = "", var favorite: Boolean = false,
                 var date: String = "")
