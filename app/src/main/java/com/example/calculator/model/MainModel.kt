package com.example.calculator.model

import io.kaen.dagger.ExpressionParser

class MainModel{

    fun getMathResult(expression: String): String {
        val parser = ExpressionParser()
        val result = parser.evaluate(expression)
        return result.toString()
    }
}