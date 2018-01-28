package id.riksasuviana.kotlinmvp.ui

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.riksasuviana.kotlinmvp.base.BasePresenter

/**
 * Created by riksa on 28/01/2018.
 */
abstract class MvpFragment<P : BasePresenter<Any>> : Fragment() {
    protected lateinit var mvpPresenter: P

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(getFragmentLayout(), container, false)
        mvpPresenter = createPresenter()
        doCreateFragment()
        return rootView
    }

    abstract fun doCreateFragment()

    abstract
    @LayoutRes
    fun getFragmentLayout(): Int

    protected abstract fun createPresenter(): P
}