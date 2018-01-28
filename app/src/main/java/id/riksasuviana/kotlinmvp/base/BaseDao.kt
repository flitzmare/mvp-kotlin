package id.riksasuviana.kotlinmvp.base

/**
 * Created by riksa on 28/01/2018.
 */
class BaseDao<T> {
    var page: Int = 0
    var total_results: Int = 0
    var total_pages: Int = 0
    var results: T? = null
}