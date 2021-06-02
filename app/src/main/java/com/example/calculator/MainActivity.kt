package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.calculator.databinding.ActivityMainBinding
import com.example.calculator.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var viewModel: MainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar!!.hide()

//        Log.i("MainActivity", "Called ViewModel")
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        //observer expression
        viewModel.expression.observe(this, Observer { newExpression ->
            binding.textExpression.text = newExpression
        })

        //numbers
        binding.buttonZero.setOnClickListener {
            viewModel._expression.setValue(viewModel.receiveValue("0")) }
        binding.buttonOne.setOnClickListener {
            viewModel._expression.setValue(viewModel.receiveValue("1")) }
        binding.buttonTwo.setOnClickListener {
            viewModel._expression.setValue(viewModel.receiveValue("2")) }
        binding.buttonThree.setOnClickListener {
            viewModel._expression.setValue(viewModel.receiveValue("3")) }
        binding.buttonFour.setOnClickListener {
            viewModel._expression.setValue(viewModel.receiveValue("4")) }
        binding.buttonFive.setOnClickListener {
            viewModel._expression.setValue(viewModel.receiveValue("5")) }
        binding.buttonSix.setOnClickListener {
            viewModel._expression.setValue(viewModel.receiveValue("6")) }
        binding.buttonSeven.setOnClickListener {
            viewModel._expression.setValue(viewModel.receiveValue("7")) }
        binding.buttonEight.setOnClickListener {
            viewModel._expression.setValue(viewModel.receiveValue("8")) }
        binding.buttonNine.setOnClickListener {
            viewModel._expression.setValue(viewModel.receiveValue("9")) }

        //operators
        binding.buttonAdd.setOnClickListener {
            viewModel._expression.setValue(viewModel.receiveValue("+")) }
        binding.buttonSub.setOnClickListener {
            viewModel._expression.setValue(viewModel.receiveValue("-")) }
        binding.buttonDiv.setOnClickListener {
            viewModel._expression.setValue(viewModel.receiveValue("/")) }
        binding.buttonMult.setOnClickListener {
            viewModel._expression.setValue(viewModel.receiveValue("*")) }
        binding.buttonMod.setOnClickListener {
            viewModel._expression.setValue(viewModel.receiveValue("%")) }

        //dot, open and close
        binding.buttonDot.setOnClickListener {
            viewModel._expression.setValue(viewModel.receiveValue(".")) }
        binding.buttonOpen.setOnClickListener {
            viewModel._expression.setValue(viewModel.receiveValue("(")) }
        binding.buttonClose.setOnClickListener {
            viewModel._expression.setValue(viewModel.receiveValue(")")) }

        // del
        binding.buttonDel.setOnClickListener {
            binding.textExpression.text = viewModel.clear()
            binding.textResult.text = ""
        }

        // equal
        binding.buttonEqual.setOnClickListener {
            binding.textResult.text = viewModel.totalResult() }
    }
}