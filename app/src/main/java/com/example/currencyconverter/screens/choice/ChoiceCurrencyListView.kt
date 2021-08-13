package com.example.currencyconverter.screens.choice

import com.example.currencyconverter.pojo.Valute

interface ChoiceCurrencyListView {
    fun showData(mutableList: MutableList<Valute>)
    fun onError()
}