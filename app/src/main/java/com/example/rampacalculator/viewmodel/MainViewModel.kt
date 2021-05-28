package com.example.rampacalculator.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rampacalculator.domain.Calculador

class MainViewModel: ViewModel() {

    val desnivel =  MutableLiveData<Double>()
    val comprimento = MutableLiveData<Double>()
    val inclinacao = MutableLiveData<Double>()
    val calculador = Calculador()

    init {
        desnivel.value = 0.0
        comprimento.value = 0.0
        inclinacao.value = 0.0
    }


    fun atualizaInclinacao(){
        val dH = desnivel.value
        val dL = comprimento.value
        inclinacao.postValue(calculador.calculaInclinacao(dH, dL))
    }
}