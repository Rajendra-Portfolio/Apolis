package iamrajendra.github.io.apolis.main

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iamrajendra.newsdragger.utils.getViewModel
import com.iamrajendra.newsdragger.utils.observeNotNull
import iamrajendra.github.io.apolis.R
import iamrajendra.github.io.apolis.api.RockyResponse
import iamrajendra.github.io.apolis.di.base.BaseActivity
import iamrajendra.github.io.apolis.main.adapter.Adapter
import iamrajendra.github.io.apolis.model.ViewState
import iamrajendra.github.io.apolis.pagination.PaginationAdapter
import iamrajendra.github.io.apolis.pagination.PostsDataSource
import kotlinx.coroutines.Dispatchers

class MainActivity : BaseActivity() {
    private val mainViewModel by lazy { getViewModel<MainViewModel>() }
    private var list: RecyclerView? =null;
     var layoutManager:LinearLayoutManager? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list = findViewById(R.id.list)
        layoutManager  = LinearLayoutManager(applicationContext);
        list?.layoutManager  = layoutManager
        /*val adapter = Adapter ();
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
*/
        var  a  = PaginationAdapter()

        list?.adapter =a
        val config = PagedList.Config.Builder()
            .setPageSize(30)
            .setEnablePlaceholders(false)
            .build()
        initializedPagedListBuilder(config).build().observe(this, Observer {

            a.submitList(it)
        })

    }

    private fun initializedPagedListBuilder(config: PagedList.Config):
            LivePagedListBuilder<Int, RockyResponse.Results> {

        val dataSourceFactory = object : DataSource.Factory<Int, RockyResponse.Results>() {
            override fun create(): DataSource<Int, RockyResponse.Results> {
                return PostsDataSource(mainViewModel.getRepository())
            }
        }
        return LivePagedListBuilder<Int, RockyResponse.Results>(dataSourceFactory, config)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {

        if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show()
            layoutManager  = GridLayoutManager(applicationContext,4);

            list?.layoutManager  = layoutManager
            list?.adapter?.notifyDataSetChanged()


        } else if (newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show()

            layoutManager  = LinearLayoutManager(applicationContext)
            list?.layoutManager  = layoutManager
            list?.adapter?.notifyDataSetChanged()

        }
        super.onConfigurationChanged(newConfig)

    }
    companion object{
        var TAG:String = MainActivity::class.java.simpleName

    }
}