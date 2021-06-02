package com.example.calculator.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.calculator.databinding.ActivityMainBinding
import com.example.calculator.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar!!.hide()

        //observer expression
        viewModel.expression.observe(this, Observer { newExpression ->
            binding.textExpression.text = newExpression
        })

        //observer total result
        viewModel.totalExpression.observe(this, Observer { newResult ->
            binding.textResult.text = newResult
        })

        //numbers
        binding.buttonZero.setOnClickListener { viewModel.receiveValue("0") }
        binding.buttonOne.setOnClickListener { viewModel.receiveValue("1") }
        binding.buttonTwo.setOnClickListener { viewModel.receiveValue("2") }
        binding.buttonThree.setOnClickListener { viewModel.receiveValue("3") }
        binding.buttonFour.setOnClickListener { viewModel.receiveValue("4") }
        binding.buttonFive.setOnClickListener { viewModel.receiveValue("5") }
        binding.buttonSix.setOnClickListener { viewModel.receiveValue("6") }
        binding.buttonSeven.setOnClickListener { viewModel.receiveValue("7") }
        binding.buttonEight.setOnClickListener { viewModel.receiveValue("8") }
        binding.buttonNine.setOnClickListener { viewModel.receiveValue("9") }

        //operators
        binding.buttonAdd.setOnClickListener { viewModel.receiveValue("+") }
        binding.buttonSub.setOnClickListener { viewModel.receiveValue("-") }
        binding.buttonDiv.setOnClickListener { viewModel.receiveValue("/") }
        binding.buttonMult.setOnClickListener { viewModel.receiveValue("*") }
        binding.buttonMod.setOnClickListener { viewModel.receiveValue("%") }

        //dot, open and close
        binding.buttonDot.setOnClickListener { viewModel.receiveValue(".") }
        binding.buttonOpen.setOnClickListener { viewModel.receiveValue("(") }
        binding.buttonClose.setOnClickListener { viewModel.receiveValue(")") }

        // del
        binding.buttonDel.setOnClickListener { viewModel.clear().toString() }

        // equal
        binding.buttonEqual.setOnClickListener { viewModel.totalResult().toString() }
    }
}