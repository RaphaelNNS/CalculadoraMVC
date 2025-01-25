package com.example.calculadoramvc.controller

import androidx.core.net.ParseException
import com.example.calculadoramvc.MainActivity
import com.example.calculadoramvc.model.Calculadora
import com.ezylang.evalex.EvaluationException

class MainCalcController(
    private var calculadora: Calculadora,
    private var mainActivity: MainActivity
){

    fun addTerm(term: String){
        calculadora.addToExpression(term)
        mainActivity.updateVisor(calculadora.expression)
    }

    fun removeTerm(){
        calculadora.removeFromExpression()
        mainActivity.updateVisor(calculadora.expression)
    }

    fun calculate() {
        try {
            var result = calculadora.evaluate()
            mainActivity.updateVisor(calculadora.expression)
        }catch (e: ParseException){
            mainActivity.showError("Erro ao analisar a expressão")
        }
        catch (e: EvaluationException){
            mainActivity.showError("Erro calcular a expressão")
        }catch (e: IllegalArgumentException){
            mainActivity.showError("A expressão esta vazia")
        }catch (e: Exception){
            mainActivity.showError("")
        }
    }
}

