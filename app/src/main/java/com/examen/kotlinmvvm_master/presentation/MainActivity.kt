package com.examen.kotlinmvvm_master.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.examen.kotlinmvvm_master.R
import com.examen.kotlinmvvm_master.presentation.ui.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
    }

    private fun initFragment() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        // Create a new instance of your fragment
        val myFragment = HomeFragment()

        // Replace the container with the fragment
        fragmentTransaction.replace(R.id.fragmentContainerView, myFragment)
        fragmentTransaction.commit() // Commit the transaction
    }

}