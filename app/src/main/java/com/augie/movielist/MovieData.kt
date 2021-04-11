package com.augie.movielist

object MovieData {
    private val name = arrayOf("Spirited Away", "Parasite", "The Dark Knight", "Your Name",
        "Raya and the Last Dragon", "Avengers : Endgame", "Interstellar", "Bohemian Rhapsody",
        "Demon Slayer : Mugen Train", "3 Idiots")
    private val synopsis = arrayOf("A young girl, Chihiro, becomes trapped in a strange new world of spirits. When her parents undergo a mysterious transformation, she must call upon the courage she never knew she had to free her family.",
        "All unemployed, Ki-taek's family takes peculiar interest in the wealthy and glamorous Parks for their livelihood until they get entangled in an unexpected incident.",
        "Batman raises the stakes in his war on crime. With the help of Lt. Jim Gordon and District Attorney Harvey Dent, Batman sets out to dismantle the remaining criminal organizations that plague the streets. The partnership proves to be effective, but they soon find themselves prey to a reign of chaos unleashed by a rising criminal mastermind known to the terrified citizens of Gotham as the Joker.",
        "High schoolers Mitsuha and Taki are complete strangers living separate lives. But one night, they suddenly switch places. Mitsuha wakes up in Taki’s body, and he in hers. This bizarre occurrence continues to happen randomly, and the two must adjust their lives around each other.",
        "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
        "After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store.",
        "The adventures of a group of explorers who make use of a newly discovered wormhole to surpass the limitations on human space travel and conquer the vast distances involved in an interstellar voyage.",
        "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
        "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!",
        "In the tradition of “Ferris Bueller’s Day Off” comes this refreshing comedy about a rebellious prankster with a crafty mind and a heart of gold. Rascal. Joker. Dreamer. Genius... You've never met a college student quite like \"Rancho.\" From the moment he arrives at India's most prestigious university, Rancho's outlandish schemes turn the campus upside down—along with the lives of his two newfound best friends. Together, they make life miserable for \"Virus,\" the school’s uptight and heartless dean. But when Rancho catches the eye of the dean's sexy daughter, Virus sets his sights on flunking out the \"3 idiots\" once and for all.")
    private val poster = intArrayOf(R.drawable.poster_spirited_away,
        R.drawable.poster_parasite, R.drawable.poster_batman, R.drawable.poster_yourname,
        R.drawable.poster_raya, R.drawable.poster_avenger, R.drawable.poster_interstellar,
        R.drawable.poster_bohemian, R.drawable.poster_kny, R.drawable.poster_3idiots)
    private val backdrop = intArrayOf(R.drawable.backdrop_spirited_away,
        R.drawable.backdrop_parasite, R.drawable.backdrop_batman, R.drawable.backdrop_yourname,
        R.drawable.backdrop_raya, R.drawable.backdrop_avenger, R.drawable.backdrop_interstellar,
        R.drawable.backdrop_bohemian, R.drawable.backdrop_kny, R.drawable.backdrop_iditos)
    private val genre = arrayOf("Animation, Family, Fantasy", "Comedy, Thriller, Drama",
        "Drama, Action, Crime, Thriller", "Romance, Animation, Drama", "Animation, Adventure, Fantasy, Family, Action, Drama",
        "Adventure, Science Fiction, Action", "Adventure, Drama, Science Fiction", "Music, Drama, History",
        "Animation, Action, Adventure, Fantasy, Drama", "Drama, Comedy")
    private val date = arrayOf("07/20/2001", "11/01/2019", "07/18/2008", "08/26/2016",
        "03/03/2021", "04/24/2019", "11/06/2014", "11/02/2018", "01/06/2021", "12/24/2009")

    val listData: ArrayList<Movie>
        get() {
            val list = arrayListOf<Movie>()
            for (position in name.indices){
                val movie = Movie()

                movie.name = name[position]
                movie.synopsis = synopsis[position]
                movie.poster = poster[position]
                movie.backdrop = backdrop[position]
                movie.genre = genre[position]
                movie.date = date[position]
                list.add(movie)
            }
            return list
        }
}