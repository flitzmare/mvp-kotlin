package id.riksasuviana.kotlinmvp.mvp.main

import android.os.Bundle
import android.widget.Toast
import com.google.gson.Gson
import id.riksasuviana.kotlinmvp.R
import id.riksasuviana.kotlinmvp.base.BaseDao
import id.riksasuviana.kotlinmvp.model.MovieModel
import id.riksasuviana.kotlinmvp.ui.MvpActivity

/**
 * Created by riksa on 28/01/2018.
 */
class MainActivity : MvpActivity<MainPresenter>(), MainView{

    override fun onSuccess(data: BaseDao<List<MovieModel>>?) {
        Toast.makeText(this, Gson().toJson(data?.results), Toast.LENGTH_LONG).show()
    }

    override fun onFailed(errorMessage: String?) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
    }

    override fun createPresenter(): MainPresenter {
        return MainPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        mvpPresenter.onGetMovie()
    }
}