package com.example.currencyconverter.pojo

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml


@Xml(name = "Valute")
data class Valute(
    @Attribute(name = "ID") var iD: String ,

    @PropertyElement(name = "NumCode") var numCode: Int ,

    @PropertyElement(name = "CharCode")
    var charCode: String ,

    @PropertyElement(name = "Nominal")
    var nominal: String ,

    @PropertyElement(name = "Name")
    var name: String ,

    @PropertyElement(name = "Value")
    var value: String,

){
    var checked:Boolean = false
}