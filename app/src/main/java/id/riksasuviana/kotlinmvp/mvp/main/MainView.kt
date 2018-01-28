package id.riksasuviana.kotlinmvp.mvp.main

import id.riksasuviana.kotlinmvp.base.BaseDao
import id.riksasuviana.kotlinmvp.base.BaseView
import id.riksasuviana.kotlinmvp.model.MovieModel

/**
 * Created by riksa on 28/01/2018.
 */
interface MainView : BaseView {
    fun onSuccess(data: BaseDao<List<MovieModel>>?)
    fun onFailed(errorMessage:String?)
}