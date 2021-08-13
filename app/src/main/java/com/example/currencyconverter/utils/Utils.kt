package com.example.currencyconverter

import android.content.Context
import android.os.CountDownTimer
import android.text.Editable
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import android.widget.Toolbar
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.currencyconverter.adapter.CurrencyAdapter
import com.example.currencyconverter.api.RetrofitInstance
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.toolbar.*
import java.lang.Exception
/*method for calculate*/
fun calculationFirstCurrency(
    count: Double,
    nominalFirst: Int,
    valueFirst: Double,
    nominalSecond: Int,
    valueSecond: Double
): String {
    val first = valueFirst / nominalFirst
    val second = valueSecond / nominalSecond

    val firstCalculate = first * count
    val secondCalculate = second * count

    return "${firstCalculate / secondCalculate * count}"
}

fun calculationSecondCurrency(
    count: Double,
    nominalFirst: Int,
    valueFirst: Double,
    nominalSecond: Int,
    valueSecond: Double
): String {
    val first = valueFirst / nominalFirst
    val second = valueSecond / nominalSecond

    val firstCalculate = first * count
    val secondCalculate = second * count

    return "${secondCalculate / firstCalculate * count}"
}

/*method for interact to EditText */
fun clearEditText(editText1: EditText, editText2: EditText) {
    if (editText1.text.isNotEmpty()) {
        editText1.text =
            Editable.Factory.getInstance().newEditable("")
    }
    if (editText2.text.isNotEmpty()) {
        editText2.text =
            Editable.Factory.getInstance().newEditable("")
    }
}

fun textCorrection(
    s: CharSequence?,
    editText1: EditText,
    editText2: EditText,
    resultOfCalculation: String
) {

    if (!s.isNullOrEmpty() && !editText1.isFocused) {

    } else if (!s.isNullOrEmpty() && editText1.isFocused) {
        editText2.text =
            Editable.Factory.getInstance().newEditable(resultOfCalculation)
    } else if (editText1.isFocused && editText1.text.isEmpty()) {
        editText2.text =
            Editable.Factory.getInstance().newEditable("")
    }
}

fun getValueFromScreen(s: CharSequence?,context:Context) : Double{
    var returnVale = 0.0
    if(!s.toString().isNullOrEmpty()){
        try {
            returnVale = s.toString().toDouble()
        }catch (e: Exception){
            Toast.makeText(context, "Wrong Value", Toast.LENGTH_SHORT).show()
        }
    }
    return returnVale
}

/*create Bars*/
fun addProgressBar(f1: DialogFragment){
    val timer = object : CountDownTimer(1200,1000){
        override fun onTick(millisUntilFinished: Long) {

        }
        override fun onFinish() {
            f1.dismiss()
        }
    }
    timer.start()
}

fun addToolBar(toolbar:androidx.appcompat.widget.Toolbar,f:DialogFragment) {
    toolbar.setOnMenuItemClickListener {
        when (it.itemId) {
            R.id.exit -> {
                f.dismiss()
                true
            }
            else -> {
                false
            }
        }
    }
}

















