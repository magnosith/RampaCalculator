
/**
 * App Desenvolvido com base na live do Canal Chico Rasia do Chicória Labs
 * */

package com.example.rampacalculator.ui.activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.example.rampacalculator.R
import com.example.rampacalculator.databinding.ActivityMainBinding
import com.example.rampacalculator.extension.formataInclinacao
import com.example.rampacalculator.viewmodel.MainViewModel
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val inclinacaoTxt by lazy {
        binding.mainInclicacaoResultado
    }

    private val desnivelSld by lazy {
        binding.mainDesnivelSlid
    }

    private val comprimentosSld by lazy {
        binding.mainComprimentoSlid
    }

    lateinit private var mViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view  = binding.root
        setContentView(view)

        initViewModel()
        initDesnivelSlid()
        initComprimentoSlid()

        initObserver()



    }

    private fun initObserver() {
        mViewModel.inclinacao.observe(this,{inclinacaoCalculada: Double? ->
            inclinacaoTxt.text = "i: " + inclinacaoCalculada?.formataInclinacao() + "%"
        })
    }

    private fun initViewModel() {
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        Toast.makeText(this, mViewModel.toString(), Toast.LENGTH_LONG).show()
    }

    private fun initComprimentoSlid() {
        comprimentosSld.addOnChangeListener { _, value, _ ->
            mViewModel.comprimento.postValue(value.toDouble())
            mViewModel.atualizaInclinacao()
        }
    }

    private fun initDesnivelSlid() {
        desnivelSld.addOnChangeListener { _, value, _ ->
            mViewModel.desnivel.postValue(value.toDouble())
            mViewModel.atualizaInclinacao()
        }
    }


    override fun onBackPressed() {
        finishAndRemoveTask()
    }


}