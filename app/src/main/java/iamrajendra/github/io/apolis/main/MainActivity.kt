package iamrajendra.github.io.apolis.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.iamrajendra.newsdragger.utils.getViewModel
import com.iamrajendra.newsdragger.utils.observeNotNull
import iamrajendra.github.io.apolis.R
import iamrajendra.github.io.apolis.di.base.BaseActivity
import iamrajendra.github.io.apolis.main.adapter.Adapter
import iamrajendra.github.io.apolis.model.ViewState

class MainActivity : BaseActivity() {
    private val mainViewModel by lazy { getViewModel<MainViewModel>() }
    private var list: RecyclerView? =null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list = findViewById(R.id.list)
        val adapter = Adapter ();
        list?.adapter = adapter



        mainViewModel.getNewsArticles().observeNotNull(this,{state ->
            when(state){
                is ViewState.Success ->{
                    Log.i(TAG, (state.data.size as Int).toString())
                    adapter.replaceItems(state.data)


                }
                is ViewState.Loading ->{
                    Log.i(TAG, "loading ... ")

                }
                is ViewState.Error ->{
                    Log.e(TAG,"Error :: "+state.message)

                }

            }


        })
    }

    companion object{
        var TAG:String = MainActivity::class.java.simpleName

    }
}