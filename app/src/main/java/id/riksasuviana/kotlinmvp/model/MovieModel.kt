package id.riksasuviana.kotlinmvp.model

/**
 * Created by riksa on 28/01/2018.
 */
class MovieModel {
    var vote_count: Int = 0
    var id: Int = 0
    var video: Boolean = false
    var vote_average: Double = 0.toDouble()
    var title: String? = null
    var popularity: Double = 0.toDouble()
    var poster_path: String? = null
    var original_language: String? = null
    var original_title: String? = null
    var backdrop_path: String? = null
    var adult: Boolean = false
    var overview: String? = null
    var release_date: String? = null
    var genre_ids: List<Int>? = null
}