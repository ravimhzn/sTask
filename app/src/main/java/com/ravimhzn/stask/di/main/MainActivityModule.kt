package com.ravimhzn.stask.di.main

import com.ravimhzn.stask.network.WThreeAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MainActivityModule {

    @Provides
    fun provideResponseFromServer(retrofit: Retrofit): WThreeAPI {
        return retrofit.create(WThreeAPI::class.java)
    }
}