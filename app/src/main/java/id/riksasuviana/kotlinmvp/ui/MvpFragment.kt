package id.riksasuviana.kotlinmvp.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import id.riksasuviana.kotlinmvp.base.BasePresenter

/**
 * Created by riksa on 28/01/2018.
 */
abstract class MvpFragment<P : BasePresenter<*>> : Fragment() {
    protected lateinit var mvpPresenter: P

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getFragmentLayout(), container, false)
    }

    override fun onStart() {
        super.onStart()

        mvpPresenter = createPresenter()

        doCreateFragment()
    }

    abstract fun doCreateFragment()

    abstract
    @LayoutRes
    fun getFragmentLayout(): Int

    protected abstract fun createPresenter(): P

    var mProgressDialog: ProgressDialog? = null

    open fun showLoading(){
        mProgressDialog = ProgressDialog(context)
        mProgressDialog?.setCancelable(false)
        mProgressDialog?.show()
    }

    open fun hideLoading(){
        if(mProgressDialog != null){
            mProgressDialog?.dismiss()
        }
    }

    fun toast(message:String?, duration:Int){
        Toast.makeText(context, message, duration).show()
    }
}