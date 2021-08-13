package com.example.currencyconverter.api

import com.example.currencyconverter.pojo.ValCurs
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface ApiFactory {
    @GET("scripts/XML_daily.asp")
    fun getCurrency(): Observable<ValCurs>
}