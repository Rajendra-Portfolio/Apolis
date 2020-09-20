package iamrajendra.github.io.apolis.di.base

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import iamrajendra.github.io.apolis.App
import iamrajendra.github.io.apolis.di.ActivityModule
import iamrajendra.github.io.apolis.di.RockyMorthyServiceModule
import iamrajendra.github.io.apolis.di.ViewModelModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        // Dagger support
        AndroidInjectionModule::class
,
        // App
        RockyMorthyServiceModule::class,
            ActivityModule::class,
        ViewModelModule::class

     ]
)


interface  AppComponent{
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(newsApp: App)
}