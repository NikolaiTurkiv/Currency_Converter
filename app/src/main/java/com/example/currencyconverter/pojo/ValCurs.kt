package com.example.currencyconverter.pojo

import com.tickaroo.tikxml.annotation.*


@Xml(name = "ValCurs")
class ValCurs {

    @Attribute(name = "Date")
    var date: String? = null

    @Attribute(name = "name")
    var name: String? = null

    @Element
    var valute: MutableList<Valute> = mutableListOf()

}