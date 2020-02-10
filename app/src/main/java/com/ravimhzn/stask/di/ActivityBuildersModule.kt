package com.ravimhzn.stask.di

import com.ravimhzn.stask.di.main.MainActivityModule
import com.ravimhzn.stask.di.main.MainActivityViewModelModule
import com.ravimhzn.stask.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
        modules = [MainActivityViewModelModule::class,
            MainActivityModule::class]
    )
    abstract fun contributeMainActivity(): MainActivity
}
