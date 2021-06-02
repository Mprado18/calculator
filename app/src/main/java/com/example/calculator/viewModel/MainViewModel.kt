package com.example.calculator.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calculator.model.MainModel

class MainViewModel: ViewModel() {

    val _expression = MutableLiveData<String>()
    val expression: LiveData<String> = _expression

    val _totalExpression = MutableLiveData<String>()

    init {
        _expression.value = ""
        _totalExpression.value = ""
//        Log.i("MainViewModel", "ViewModel created")
    }

    fun receiveValue(value: String): String {
        _expression.value += value
        return _expression.value.toString()
    }

    fun clear(): String {
        _expression.value = ""
        return _expression.value.toString()
    }

    fun totalResult(): String {
        val model = MainModel()
        _totalExpression.value = model.getMathResult(_expression.value!!)
        return _totalExpression.value.toString()
    }

    override fun onCleared() {
        super.onCleared()
//        Log.i("MainViewModel", "ViewModel destroyed")
    }
}


