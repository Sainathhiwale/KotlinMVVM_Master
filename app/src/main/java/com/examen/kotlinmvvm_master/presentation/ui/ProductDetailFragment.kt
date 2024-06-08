package com.examen.kotlinmvvm_master.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.examen.kotlinmvvm_master.R
import com.examen.kotlinmvvm_master.data.model.allproductshop.ShopItem
import com.examen.kotlinmvvm_master.databinding.FragmentProductDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailFragment : Fragment() {
    private  var TAG = ProductDetailFragment::class.simpleName
    private lateinit var binding: FragmentProductDetailBinding
    private lateinit var shopItem: ShopItem
    private var like = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shopItem = ProductDetailFragmentArgs.fromBundle(requireArguments()).shopItem
        Log.d(TAG, "onCreate: " + shopItem.category)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProductDetailBinding.bind(view)
        updateViews()
    }

    private fun updateViews() {
        binding.productDetailPrice.text = "USD ${shopItem.price}"
        binding.productDetailTitle.text = shopItem.title
        binding.productDetailDescription.text = shopItem.description

        Glide.with(binding.productDetailImage)
            .load(shopItem.image)
            .into(binding.productDetailImage)

        binding.productDetailRating.text = "${shopItem.rating?.rate}"
        binding.productDetailReviews.text = "${shopItem.rating?.count} Reviews"
    }


}