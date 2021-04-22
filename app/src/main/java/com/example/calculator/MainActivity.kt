package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.kaen.dagger.ExpressionParser
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        // numbers
        buttonZero.setOnClickListener { receiveValue("0") }
        buttonOne.setOnClickListener { receiveValue("1") }
        buttonTwo.setOnClickListener { receiveValue("2") }
        buttonThree.setOnClickListener { receiveValue("3") }
        buttonFour.setOnClickListener { receiveValue("4") }
        buttonFive.setOnClickListener { receiveValue("5") }
        buttonSix.setOnClickListener { receiveValue("6") }
        buttonSeven.setOnClickListener { receiveValue("7") }
        buttonEight.setOnClickListener { receiveValue("8") }
        buttonNine.setOnClickListener { receiveValue("9") }

        // operators
        buttonAdd.setOnClickListener { receiveValue("+") }
        buttonSub.setOnClickListener { receiveValue("-") }
        buttonMult.setOnClickListener { receiveValue("*") }
        buttonDiv.setOnClickListener { receiveValue("/") }

        // dot
        buttonDot.setOnClickListener { receiveValue(".") }

        // del
        buttonDel.setOnClickListener {
            textExpression.text = ""
            textResult.text = ""
        }

        // open and close
        buttonOpen.setOnClickListener { receiveValue("(") }
        buttonClose.setOnClickListener { receiveValue(")") }

        // equal
        buttonEqual.setOnClickListener {
            textResult.text = getMathResult(textExpression.text.toString())
        }
    }

    fun receiveValue(value: String): String {
        if (textResult.text == "") {
            textExpression.append(value)
        }
        return value
    }

    fun getMathResult(expression: String): String {
        val parser = ExpressionParser()
        val result = parser.evaluate(expression)
        return result.toString()
    }

}