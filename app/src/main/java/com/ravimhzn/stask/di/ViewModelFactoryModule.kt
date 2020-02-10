package com.ravimhzn.stask.di

import androidx.lifecycle.ViewModelProvider
import com.ravimhzn.daggerinkotlin.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

}