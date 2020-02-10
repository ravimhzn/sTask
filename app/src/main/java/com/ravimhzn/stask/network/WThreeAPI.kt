package com.ravimhzn.stask.network

import io.reactivex.Flowable
import retrofit2.http.GET

interface WThreeAPI {

    @GET("TR/PNG/iso_8859-1.txt")
    fun getTextFromServer(): Flowable<String>
}