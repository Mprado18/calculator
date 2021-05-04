package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculator.databinding.ActivityMainBinding
import com.example.calculator.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar!!.hide()

        // numbers
        binding.buttonZero.setOnClickListener {
            binding.textExpression.text = viewModel.receiveValue("0") }
        binding.buttonOne.setOnClickListener {
            binding.textExpression.text = viewModel.receiveValue("1") }
        binding.buttonTwo.setOnClickListener {
            binding.textExpression.text = viewModel.receiveValue("2") }
        binding.buttonThree.setOnClickListener {
            binding.textExpression.text = viewModel.receiveValue("3") }
        binding.buttonFour.setOnClickListener {
            binding.textExpression.text = viewModel.receiveValue("4") }
        binding.buttonFive.setOnClickListener {
            binding.textExpression.text = viewModel.receiveValue("5") }
        binding.buttonSix.setOnClickListener {
            binding.textExpression.text = viewModel.receiveValue("6") }
        binding.buttonSeven.setOnClickListener {
            binding.textExpression.text = viewModel.receiveValue("7") }
        binding.buttonEight.setOnClickListener {
            binding.textExpression.text = viewModel.receiveValue("8") }
        binding.buttonNine.setOnClickListener {
            binding.textExpression.text = viewModel.receiveValue("9") }

        // operators
        binding.buttonAdd.setOnClickListener {
            binding.textExpression.text = viewModel.receiveValue("+") }
        binding.buttonSub.setOnClickListener {
            binding.textExpression.text = viewModel.receiveValue("-") }
        binding.buttonMult.setOnClickListener {
            binding.textExpression.text = viewModel.receiveValue("*") }
        binding.buttonDiv.setOnClickListener {
            binding.textExpression.text = viewModel.receiveValue("/") }

        // dot
        binding.buttonDot.setOnClickListener {
            binding.textExpression.text = viewModel.receiveValue(".") }

        // del
        binding.buttonDel.setOnClickListener {
            binding.textExpression.text = viewModel.clear()
            binding.textResult.text = ""
        }

        // open and close
        binding.buttonOpen.setOnClickListener {
            binding.textExpression.text = viewModel.receiveValue("(") }
        binding.buttonClose.setOnClickListener {
            binding.textExpression.text = viewModel.receiveValue(")") }

        // equal
        binding.buttonEqual.setOnClickListener {
            binding.textResult.text = viewModel.totalResult()
        }
    }
}