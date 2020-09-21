package iamrajendra.github.io.apolis.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import iamrajendra.github.io.apolis.api.RockyMorthy
import iamrajendra.github.io.apolis.api.RockyResponse
import iamrajendra.github.io.apolis.model.ViewState
import iamrajendra.github.io.apolis.repo.RockyMorthyRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(
    val rockyMorthyRepository: RockyMorthyRepository
) : ViewModel(){

    private val newsArticles: LiveData<ViewState<List<RockyResponse.Results>>> = rockyMorthyRepository.getMorphyData().asLiveData()

    /**
     * Return news articles to observeNotNull on the UI.
     */
    fun getNewsArticles(): LiveData<ViewState<List<RockyResponse.Results>>> = newsArticles
    fun  getRepository():RockyMorthyRepository = rockyMorthyRepository
}