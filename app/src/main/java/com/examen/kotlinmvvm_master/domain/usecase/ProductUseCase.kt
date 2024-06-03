package com.examen.kotlinmvvm_master.domain.usecase

import com.examen.kotlinmvvm_master.data.model.category.Category
import com.examen.kotlinmvvm_master.data.utils.Resource
import com.examen.kotlinmvvm_master.domain.repository.ShopRepository
import javax.inject.Inject

class ProductUseCase @Inject constructor(private val shopRepository: ShopRepository) {

    suspend fun getAllCategories():Resource<Category>{
        return shopRepository.getAllCategories()
    }

}