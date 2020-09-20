package iamrajendra.github.io.apolis.repo

import iamrajendra.github.io.apolis.api.RockyMorthy
import iamrajendra.github.io.apolis.api.RockyResponse
import iamrajendra.github.io.apolis.model.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RockyMorthyRepository  @Inject constructor(
    private val rockyMorthy: RockyMorthy
){
    /**
     * Fetch the news articles from database if exist else fetch from web
     * and persist them in the database
     */
    fun getMorphyData(): Flow<ViewState<List<RockyResponse.Results>>> {
        return flow {
            emit(ViewState.loading())

            val newsSource = rockyMorthy.getData()

            // 3. Get articles from database [Single source of truth]
            emit(ViewState.success(newsSource.results))
        }.catch {

            emit(ViewState.error(it.message.orEmpty()))

        } .flowOn(Dispatchers.IO)  }
}