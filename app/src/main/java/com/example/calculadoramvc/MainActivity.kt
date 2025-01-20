package com.example.calculadoramvc

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadoramvc.controller.MainCalcController
import com.example.calculadoramvc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var controller: MainCalcController
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        controller = MainCalcController(this)
        setupButtonListeners()
        controller.showError("Erro ao analisar a expressão")

    }

    private fun setupButtonListeners() {
        val buttons = listOf(
            binding.btn1,
            binding.btn2,
            binding.btn3,
            binding.btn4,
            binding.btn5,
            binding.btn6,
            binding.btn7,
            binding.btn8,
            binding.btn9,
            binding.btn0,
            binding.btnAdd,
            binding.btnDot,
            binding.btnDivide,
            binding.btnMultiply,
            binding.btnSubtract
        )

        buttons.forEach { button ->
            button.setOnClickListener {
                controller.addTermToVisor(button.text.toString())
            }
        }

        binding.btnBackspace.setOnClickListener{
            controller.removeTermFromVisor()
        }
        binding.btnEqual.setOnClickListener{
            controller.calculate()
        }
    }

}