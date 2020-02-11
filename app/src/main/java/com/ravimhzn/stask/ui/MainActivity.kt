package com.ravimhzn.stask.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ravimhzn.stask.R
import dagger.android.support.DaggerAppCompatActivity
import okhttp3.OkHttpClient
import okhttp3.Request
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), View.OnClickListener {

    private var TAG = "MainActivity::"

    @Inject
    lateinit var tString: String

    @Inject
    lateinit var providerFactory: ViewModelProvider.Factory

    lateinit var viewModel: MainActivityViewModel

    lateinit var u: String

    private lateinit var tvResponse: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvResponse = findViewById(R.id.tvResponse)
        findViewById<Button>(R.id.settings).setOnClickListener(this)
        initializeViewModel()
        subscribeToObservers()
    }


    private fun subscribeToObservers() {
        viewModel.getStringWithLiveData().observe(this,
            Observer<String> { t ->
                Log.d(TAG, "DATA FROM SERVER:: $t")
                tvResponse.text = t
            }
        )
    }

    private fun initializeViewModel() {
        viewModel =
            ViewModelProvider(this, providerFactory).get(MainActivityViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        //test() // -> This will result in Caused by: android.os.NetworkOnMainThreadException
    }

    private fun test() {
        u = "https://www.w3.org/TR/PNG/iso_8859-1.txt"
        Log.d(
            TAG,
            OkHttpClient().newCall(Request.Builder().url(u).build()).execute().body().toString()
        )
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.settings -> {
                goToSettingsActivity()
            }
        }
    }

    private fun goToSettingsActivity() {
        startActivity(Intent(this, Settings::class.java))
    }
}
