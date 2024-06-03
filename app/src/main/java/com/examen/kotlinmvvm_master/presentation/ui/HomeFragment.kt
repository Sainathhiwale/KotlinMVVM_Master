package com.examen.kotlinmvvm_master.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.examen.kotlinmvvm_master.R
import com.examen.kotlinmvvm_master.data.model.category.Category2
import com.examen.kotlinmvvm_master.data.utils.Resource
import com.examen.kotlinmvvm_master.databinding.FragmentHomeBinding
import com.examen.kotlinmvvm_master.presentation.ui.adapter.HomeShopAdapter
import com.examen.kotlinmvvm_master.presentation.viewmodel.HomeViewModel
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val TAG= HomeFragment::class.java.simpleName
    // use for check and unchecked
    private var category2 = mutableListOf<Category2>()

    @Inject
     lateinit var homeViewModel: HomeViewModel
     @Inject
     lateinit var homeShopAdapter: HomeShopAdapter

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
        initProduct()
    }

    private fun initProduct() {
        homeViewModel.getAllProducts()
        homeViewModel.products.observe(viewLifecycleOwner){ shop->
            when(shop){
             is Resource.Success ->{
                 homeShopAdapter.differ.submitList(shop.data)
                  fragmentHomeBinding.homeRecyclerView.visibility = View.VISIBLE
                  fragmentHomeBinding.homeRecyclerView.adapter =homeShopAdapter
                 Log.d("HomeFragment", "${shop.data}")
                }
                is Resource.Loading -> {
                    //binding.homeRecyclerView.visibility = View.INVISIBLE
                    Log.i("HomeFragment", "Loading...")
                }

                is Resource.Error -> {
                    Log.i("HomeFragment", "${shop.message}")
                }
            }
        }
    }

    private fun initAllCategory() {
        homeViewModel.getAllCategories()
        homeViewModel.categories.observe(viewLifecycleOwner) { response->
            Log.d(TAG, "initAllCategory: "+ response.data)
            if (response.data!=null ){
              val categories = response.data
                val chip = Chip(requireContext())
                chip.text = "all"
                chip.id =0
                chip.isChecked = true
                category2.clear()
                fragmentHomeBinding.chipGroup.removeAllViews()
                category2.add(Category2(0,"All"))
                fragmentHomeBinding.chipGroup.addView(chip)
                categories?.forEachIndexed { index, category->
                   val chip =Chip(requireContext())
                    chip.text =category
                    chip.id = index+1
                    category2.add(Category2(index,category))
                    fragmentHomeBinding.chipGroup.addView(chip)
                }
            }else{
                Log.d(TAG, "initAllCategory:error found " )
            }

        }

    }


}