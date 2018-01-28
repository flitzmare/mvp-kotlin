package id.riksasuviana.kotlinmvp.mvp.main

import id.riksasuviana.kotlinmvp.base.BaseDao
import id.riksasuviana.kotlinmvp.base.BasePresenter
import id.riksasuviana.kotlinmvp.model.MovieModel
import rx.Observer
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by riksa on 28/01/2018.
 */
class MainPresenter(mainView: MainView) : BasePresenter<MainView>() {
    init {
        attachView(mainView)
    }

    fun onGetMovie(){
        mvpView?.showLoading()
        serviceApi.getMovie()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object: Observer<BaseDao<List<MovieModel>>> {
                    override fun onError(e: Throwable) {
                        mvpView?.hideLoading()
                        mvpView?.onFailed(e.message)
                    }

                    override fun onNext(t: BaseDao<List<MovieModel>>?) {
                        mvpView?.onSuccess(t)
                    }

                    override fun onCompleted() {
                        mvpView?.hideLoading()
                    }
                })

    }
}