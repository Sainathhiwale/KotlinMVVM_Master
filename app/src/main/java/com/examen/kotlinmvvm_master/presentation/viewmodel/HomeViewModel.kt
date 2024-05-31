package com.examen.kotlinmvvm_master.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.examen.kotlinmvvm_master.data.model.Category
import com.examen.kotlinmvvm_master.data.utils.Network.isNetworkAvailable
import com.examen.kotlinmvvm_master.data.utils.Resource
import com.examen.kotlinmvvm_master.domain.usecase.ProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val app: Application,
    private val productUseCase: ProductUseCase
) : AndroidViewModel(app) {
    val categories: MutableLiveData<Resource<Category>> = MutableLiveData()

    fun getAllCategories() = viewModelScope.launch(IO) {
        categories.postValue(Resource.Loading())
        try {
            if (isNetworkAvailable(app)) {
                val apiResult = productUseCase.getAllCategories()
                categories.postValue(apiResult)
            }else{
                categories.postValue(Resource.Error(message = "Internet not available"))
            }
        } catch (e: Exception) {
            categories.postValue(Resource.Error(message = "${e.localizedMessage} ?: Unknown Error"))
        }
    }

}