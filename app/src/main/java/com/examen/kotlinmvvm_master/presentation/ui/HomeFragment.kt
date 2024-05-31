package com.examen.kotlinmvvm_master.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.examen.kotlinmvvm_master.R
import com.examen.kotlinmvvm_master.databinding.FragmentHomeBinding
import com.examen.kotlinmvvm_master.presentation.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val TAG= HomeFragment::class.java.simpleName
    @Inject
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentHomeBinding = FragmentHomeBinding.bind(view)
        initAllCategory()
    }

    private fun initAllCategory() {
        homeViewModel.getAllCategories()
        homeViewModel.categories.observe(viewLifecycleOwner) {
            Log.d(TAG, "initAllCategory: " + it.data)
        }
    }


}