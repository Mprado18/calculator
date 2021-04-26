package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculator.databinding.ActivityMainBinding
import io.kaen.dagger.ExpressionParser

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar!!.hide()

        // numbers
        binding.buttonZero.setOnClickListener { receiveValue("0") }
        binding.buttonOne.setOnClickListener { receiveValue("1") }
        binding.buttonTwo.setOnClickListener { receiveValue("2") }
        binding.buttonThree.setOnClickListener { receiveValue("3") }
        binding.buttonFour.setOnClickListener { receiveValue("4") }
        binding.buttonFive.setOnClickListener { receiveValue("5") }
        binding.buttonSix.setOnClickListener { receiveValue("6") }
        binding.buttonSeven.setOnClickListener { receiveValue("7") }
        binding.buttonEight.setOnClickListener { receiveValue("8") }
        binding.buttonNine.setOnClickListener { receiveValue("9") }

        // operators
        binding.buttonAdd.setOnClickListener { receiveValue("+") }
        binding.buttonSub.setOnClickListener { receiveValue("-") }
        binding.buttonMult.setOnClickListener { receiveValue("*") }
        binding.buttonDiv.setOnClickListener { receiveValue("/") }

        // dot
        binding.buttonDot.setOnClickListener { receiveValue(".") }

        // del
        binding.buttonDel.setOnClickListener {
            binding.textExpression.text = ""
            binding.textResult.text = ""
        }

        // open and close
        binding.buttonOpen.setOnClickListener { receiveValue("(") }
        binding.buttonClose.setOnClickListener { receiveValue(")") }

        // equal
        binding.buttonEqual.setOnClickListener {
            binding.textResult.text = getMathResult(binding.textExpression.text.toString())
        }
    }

    private fun receiveValue(value: String): String {
        if (binding.textResult.text == "") {
            binding.textExpression.append(value)
        }
        return value
    }

    private fun getMathResult(expression: String): String {
        val parser = ExpressionParser()
        val result = parser.evaluate(expression)
        return result.toString()
    }
}