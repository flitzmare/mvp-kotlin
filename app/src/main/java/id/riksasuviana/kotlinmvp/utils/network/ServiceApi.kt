package id.riksasuviana.kotlinmvp.utils.network

import id.riksasuviana.kotlinmvp.base.BaseDao
import id.riksasuviana.kotlinmvp.model.MovieModel
import retrofit2.http.GET
import rx.Observable

/**
 * Created by riksa on 28/01/2018.
 */
interface ServiceApi {
    @GET("3/discover/movie?api_key=1b2f29d43bf2e4f3142530bc6929d341&sort_by=popularity.desc")
    fun getMovie(): Observable<BaseDao<List<MovieModel>>>
}