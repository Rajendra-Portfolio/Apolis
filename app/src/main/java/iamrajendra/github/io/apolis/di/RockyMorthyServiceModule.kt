package iamrajendra.github.io.apolis.di

import dagger.Module
import dagger.Provides
import iamrajendra.github.io.apolis.api.RockyMorthy
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RockyMorthyServiceModule {
    @Singleton
    @Provides
    fun provideRockMorthyService(): RockyMorthy {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RockyMorthy::class.java)
    }

    companion object {
        private const val BASE_URL = "https://rickandmortyapi.com/"
    }

}