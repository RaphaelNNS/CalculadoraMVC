package com.example.calculadoramvc.controller

import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.net.ParseException
import com.example.calculadoramvc.MainActivity
import com.example.calculadoramvc.R
import com.example.calculadoramvc.model.Calculadora
import com.ezylang.evalex.EvaluationException

class MainCalcController(
    private var mainActivity: MainActivity
) {

    val visor = mainActivity.findViewById<TextView>(R.id.tvResult)
    val calculadora = Calculadora()


    fun addTermToVisor(term: String){
        calculadora.addToExpression(term)
        updateVisor()
    }

    fun removeTermFromVisor(){
        calculadora.removeFromExpression()
        updateVisor()
    }

    fun showError(s: String) {
        var alert = AlertDialog.Builder(mainActivity)
        alert.setTitle("ERRO")
        alert.setMessage("Voce esta tentando efetuar uma operação não permitida.\n$s")
        alert.setNeutralButton("Voltar"){_,_ ->

        }
        alert.create().show()
    }

    fun updateVisor() {
        visor.text = calculadora.expression
    }

    fun calculate() {
        try {
            var result = calculadora.evaluate()
            visor.text = result
        }catch (e: ParseException){
            showError("Erro ao analisar a expressão")
        }
        catch (e: EvaluationException){
            showError("Erro calcular a expressão")
        }catch (e: IllegalArgumentException){
            showError("A expressão esta vazia")
        }catch (e: Exception){
            showError("")
        }

    }


}

