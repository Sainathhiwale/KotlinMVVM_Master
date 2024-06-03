package com.examen.kotlinmvvm_master.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.examen.kotlinmvvm_master.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


}