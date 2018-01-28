package id.riksasuviana.kotlinmvp.base

import id.riksasuviana.kotlinmvp.utils.network.ApiClient
import id.riksasuviana.kotlinmvp.utils.network.ServiceApi

/**
 * Created by riksa on 28/01/2018.
 */
open class BasePresenter<V> {
    var mvpView:V? = null
    protected lateinit var serviceApi: ServiceApi

    fun attachView(mvpView:V){
        this.mvpView = mvpView
        serviceApi = ApiClient.request().create(ServiceApi::class.java)
    }

    fun detachView(){
        this.mvpView = null
    }
}