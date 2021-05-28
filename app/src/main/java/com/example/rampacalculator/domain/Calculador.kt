package com.example.rampacalculator.domain

class Calculador {

    fun calculaInclinacao(dH: Double?, dL: Double?): Double{
        // Pegar desnivel e comprimento
        // Calcular inclicanação
        // Atualizar o valor da inclicanação


        try {
            if (dH != null && dL !=null){
                return dH / dL *100
            }
        }catch (ex: ArithmeticException){
            ex.printStackTrace()
        }
        return Double.POSITIVE_INFINITY
    }

}