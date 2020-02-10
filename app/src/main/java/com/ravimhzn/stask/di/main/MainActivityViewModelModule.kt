package com.ravimhzn.stask.di.main

import androidx.lifecycle.ViewModel
import com.ravimhzn.stask.di.ViewModelKey
import com.ravimhzn.stask.ui.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainActivityViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindAuthViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel
}