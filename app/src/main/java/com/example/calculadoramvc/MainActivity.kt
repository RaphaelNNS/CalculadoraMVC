package com.example.calculadoramvc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadoramvc.controller.MainCalcController
import com.example.calculadoramvc.databinding.ActivityMainBinding
import com.example.calculadoramvc.model.Calculadora

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    private lateinit var visor: TextView
    private lateinit var controller: MainCalcController
    private lateinit var calculadora: Calculadora


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

        calculadora = Calculadora()
        controller = MainCalcController(calculadora, this)
        setupButtonListeners()
        visor = binding.tvResult
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
                controller.addTerm(button.text.toString())
            }
        }
        binding.btnBackspace.setOnClickListener{
            controller.removeTerm()
        }
        binding.btnEqual.setOnClickListener{
            controller.calculate()
        }
    }

    fun showError(s: String) {
        var alert = AlertDialog.Builder(this)
        alert.setTitle("ERRO")
        alert.setMessage("Voce esta tentando efetuar uma operação não permitida.\n$s")
        alert.setNeutralButton("Voltar"){_,_ ->

        }
        alert.create().show()
    }


    fun updateVisor(expression: String) {
        visor.text = expression
    }

}