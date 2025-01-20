package com.example.calculadoramvc.model

import androidx.core.net.ParseException
import com.ezylang.evalex.EvaluationException
import com.ezylang.evalex.Expression


class Calculadora {

   var expression = ""

    fun addToExpression(term: String){
        this.expression += term
    }

    fun removeFromExpression(){
        if(expression.isNotEmpty()){
            this.expression = expression.removeRange(expression.length -1, expression.length)
        }
    }

    fun evaluate(): String {
        if (expression.isBlank()) {
            throw IllegalArgumentException("Expression cannot be empty or blank")
        }
        try{
            var result = Expression(expression).evaluate().value
            return result.toString()
        }catch (e: ParseException){
            throw e
        }catch (e: EvaluationException){
            throw e
        }

    }

    override fun toString(): String {
        return "Calculadora(expression='$expression')"
    }

}
