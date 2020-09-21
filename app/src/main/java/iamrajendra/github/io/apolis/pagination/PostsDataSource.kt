package iamrajendra.github.io.apolis.pagination

import android.app.Activity
import android.util.Log
import androidx.lifecycle.*
import androidx.paging.PageKeyedDataSource
import com.iamrajendra.newsdragger.utils.observeNotNull
import iamrajendra.github.io.apolis.api.RockyResponse
import iamrajendra.github.io.apolis.main.MainActivity
import iamrajendra.github.io.apolis.model.ViewState
import iamrajendra.github.io.apolis.repo.RockyMorthyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class PostsDataSource(
     val rockyMorthyRepository: RockyMorthyRepository
) : PageKeyedDataSource<Int, RockyResponse.Results>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, RockyResponse.Results>
    ) {
        val currentPage = 1
        val nextPage = currentPage + 1

        var result: LiveData<ViewState<List<RockyResponse.Results>>> =
            rockyMorthyRepository.getMorphyData(currentPage).asLiveData()
        GlobalScope.launch(Dispatchers.Main) {
            // your code here...
            result.observeForever {
                    state ->
                when (state) {
                    is ViewState.Success -> {
                        Log.i(MainActivity.TAG, (state.data.size as Int).toString())

                        callback.onResult(state.data, currentPage, nextPage)

                    }
                    is ViewState.Loading -> {
                        Log.i(MainActivity.TAG, "loading ... ")

                    }
                    is ViewState.Error -> {
                        Log.e(MainActivity.TAG, "Error :: " + state.message)

                    }

                }


            }
        }



    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, RockyResponse.Results>
    ) {

        var result: LiveData<ViewState<List<RockyResponse.Results>>> =
            rockyMorthyRepository.getMorphyData(params.key).asLiveData()
        GlobalScope.launch(Dispatchers.Main) {
            result.observeForever { state ->
                when (state) {
                    is ViewState.Success -> {
                        Log.i(MainActivity.TAG, (state.data.size as Int).toString())

                        callback.onResult(state.data, params.key)

                    }
                    is ViewState.Loading -> {
                        Log.i(MainActivity.TAG, "loading ... ")

                    }
                    is ViewState.Error -> {
                        Log.e(MainActivity.TAG, "Error :: " + state.message)

                    }

                }

            }
        }

    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, RockyResponse.Results>
    ) {
        var result: LiveData<ViewState<List<RockyResponse.Results>>> =
            rockyMorthyRepository.getMorphyData(params.key).asLiveData()
        GlobalScope.launch(Dispatchers.Main) {
            result.observeForever { state ->
                when (state) {
                    is ViewState.Success -> {
                        Log.i(MainActivity.TAG, (state.data.size as Int).toString())

                        callback.onResult(state.data, params.key)

                    }
                    is ViewState.Loading -> {
                        Log.i(MainActivity.TAG, "loading ... ")

                    }
                    is ViewState.Error -> {
                        Log.e(MainActivity.TAG, "Error :: " + state.message)

                    }

                }

            }
        }


    }


}