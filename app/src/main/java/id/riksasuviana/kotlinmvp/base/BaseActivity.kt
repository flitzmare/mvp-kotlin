package id.riksasuviana.kotlinmvp.base

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup

/**
 * Created by riksa on 28/01/2018.
 */
open class BaseActivity : AppCompatActivity() {

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
    }

    override fun setContentView(view: View?) {
        super.setContentView(view)
    }

    override fun setContentView(view: View?, params: ViewGroup.LayoutParams?) {
        super.setContentView(view, params)
    }

    lateinit var mProgressDialog: ProgressDialog

    fun showProgressDialog(){
        mProgressDialog = ProgressDialog(this)
        mProgressDialog.setCancelable(false)
        mProgressDialog.show()
    }

    fun showProgressDialog(message:String){
        mProgressDialog = ProgressDialog(this)
        mProgressDialog.setMessage(message)
        mProgressDialog.setCancelable(false)
        mProgressDialog.show()
    }

    fun dismissProgressDialog(){
        if(mProgressDialog.isShowing){
            mProgressDialog.dismiss()
        }
    }

}