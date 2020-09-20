package iamrajendra.github.io.apolis.api

import retrofit2.http.GET

interface RockyMorthy{

    @GET(" /api/character/")
    suspend fun getData(): RockyResponse

}