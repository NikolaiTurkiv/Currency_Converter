package com.example.currencyconverter.screens.calculate

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.currencyconverter.pojo.Valute

open class CalculateFragmentPresenter() : ViewModel() {

    val firstValuteLiveData : MutableLiveData<Valute> by lazy{
        MutableLiveData<Valute>()
    }
    val secondValuteLiveData : MutableLiveData<Valute> by lazy {
        MutableLiveData<Valute>()
    }
}