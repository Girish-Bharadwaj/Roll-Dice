package com.example.rolldice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class viewModel:ViewModel() {
val number=MutableLiveData<Int>()
init {
    number.value=0
}
    fun generate()
    {
        number.value= Random().nextInt(6)+1
    }
}