package com.example.currencyconverter.pojo

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.ElementNameMatcher
import com.tickaroo.tikxml.annotation.Path
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "main",inheritance = true)
data class MainPojo(
    @Path("Valute")
    @Element(name = "ValCurs")
    var valCurs: ValCurs
)