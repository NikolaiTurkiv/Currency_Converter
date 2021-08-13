package com.example.currencyconverter.screens.choice

import android.util.Log
import com.example.currencyconverter.api.RetrofitInstance
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class ChoiceCurrencyListPresenter(var choiceCurrencyListView: ChoiceCurrencyListView) {

    private lateinit var disposable: Disposable

    fun loadData() {
        disposable = RetrofitInstance.instance.getCurrency()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                       choiceCurrencyListView.showData(it.valute)

            }, {
               choiceCurrencyListView.onError()
            }, {

            })
    }

    fun dispose(){
        disposable.dispose()
    }
}
