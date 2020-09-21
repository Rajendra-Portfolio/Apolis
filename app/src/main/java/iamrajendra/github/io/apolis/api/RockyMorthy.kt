package iamrajendra.github.io.apolis.api

import android.graphics.pdf.PdfDocument
import retrofit2.http.GET
import retrofit2.http.Query

interface RockyMorthy{

    @GET(" /api/character/")
    suspend fun getData(@Query("page") page: Int): RockyResponse

}