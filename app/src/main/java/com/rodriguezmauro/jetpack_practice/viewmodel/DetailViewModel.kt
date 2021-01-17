package com.rodriguezmauro.jetpack_practice.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rodriguezmauro.jetpack_practice.model.DogBreed

class DetailViewModel: ViewModel() {
    val dogBreed = MutableLiveData<DogBreed>()

    fun fetch() {

    }
}