package id.riksasuviana.kotlinmvp.ui

import android.os.Bundle
import id.riksasuviana.kotlinmvp.base.BaseActivity
import id.riksasuviana.kotlinmvp.base.BasePresenter

/**
 * Created by riksa on 28/01/2018.
 */
abstract class MvpActivity<P : BasePresenter<*>> : BaseActivity() {

    protected lateinit var mvpPresenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        mvpPresenter = createPresenter()
        super.onCreate(savedInstanceState)
    }

    protected abstract fun createPresenter(): P

    override fun onDestroy() {
        super.onDestroy()
        if(mvpPresenter != null){
            mvpPresenter.detachView()
        }
    }

    open fun showLoading(){
        showProgressDialog()
    }

    open fun hideLoading(){
        dismissProgressDialog()
    }

}