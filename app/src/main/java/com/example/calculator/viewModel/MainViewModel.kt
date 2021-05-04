package com.example.calculator.viewModel

import com.example.calculator.model.MainModel

class MainViewModel {

    var expression: String = ""
    fun receiveValue(value: String): String {
        expression += value
        return expression
    }

    fun clear(): String {
        expression = ""
        return expression
    }

    fun totalResult(): String {
        val model: MainModel = MainModel()
        return model.getMathResult(expression)
    }
}


