package iamrajendra.github.io.apolis.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import iamrajendra.github.io.apolis.main.MainActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}
