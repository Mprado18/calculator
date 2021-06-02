package com.example.calculator.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calculator.model.MainModel

class MainViewModel: ViewModel() {

    val expression = MutableLiveData<String>()

    val totalExpression = MutableLiveData<String>()

    init {
        expression.value = ""
        totalExpression.value = ""
    }

    fun receiveValue(value: String) {
        expression.value += value
    }

    fun clear() {
        expression.value = ""
        totalExpression.value = ""
    }

    fun totalResult() {
        val model = MainModel()
        totalExpression.value = model.getMathResult(expression.value!!)
    }

    override fun onCleared() {
        super.onCleared()
    }
}


