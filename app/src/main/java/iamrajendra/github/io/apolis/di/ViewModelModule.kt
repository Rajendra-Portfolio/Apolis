package iamrajendra.github.io.apolis.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import iamrajendra.github.io.apolis.di.base.ViewModelFactory
import iamrajendra.github.io.apolis.di.base.ViewModelKey
import iamrajendra.github.io.apolis.main.MainViewModel

@Module
abstract  class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindNewsArticleViewModel(mainViewModel:  MainViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}