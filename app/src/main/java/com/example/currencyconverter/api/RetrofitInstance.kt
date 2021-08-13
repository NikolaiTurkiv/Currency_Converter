package com.example.currencyconverter.api

import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.converter.htmlescape.HtmlEscapeStringConverter
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory


object RetrofitInstance {
    private const val BASE_URL = "http://www.cbr.ru/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(
            TikXmlConverterFactory.create()
        )
        .addConverterFactory(
            TikXmlConverterFactory.create()
        )
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    val instance = retrofit.create(ApiFactory::class.java)
}