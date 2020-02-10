package com.ravimhzn.stask.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams

import androidx.lifecycle.ViewModel
import com.ravimhzn.stask.di.main.MainActivityModule
import com.ravimhzn.stask.network.WThreeAPI
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * By Default viewmodels doesn't support constructor injection. That is why
 * we had to add ViewModelFactoryModule and configure accordingly
 */
class MainActivityViewModel @Inject constructor(wThreeAPI: WThreeAPI) : ViewModel() {

    private val TAG: String = "MainActivityViewModel::"
    private var wThreeAPI: WThreeAPI = wThreeAPI

    fun getStringWithLiveData(): LiveData<String> {
        return LiveDataReactiveStreams.fromPublisher(
            this.wThreeAPI.getTextFromServer()
                .subscribeOn(Schedulers.io())
        )
    }

    private fun basic(){
        wThreeAPI.getTextFromServer()
            .toObservable()
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<String> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: String) {
                    Log.d(TAG, "SUCCESS:: $t")
                }

                override fun onError(e: Throwable) {
                    Log.d(TAG, "ERROR:: $e")
                }

            })
    }
}