package com.example.currencyconverter.screens.calculate

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.example.currencyconverter.*
import com.example.currencyconverter.databinding.FragmentCalculateBinding
import com.example.currencyconverter.pojo.Valute
import com.example.currencyconverter.screens.choice.first.FirstChoiceFragment
import com.example.currencyconverter.screens.choice.second.SecondChoiceFragment
import com.example.currencyconverter.screens.download.DownloadFragment
import kotlinx.android.synthetic.main.fragment_calculate.*


class CalculateFragment : Fragment() {

    lateinit var binding: FragmentCalculateBinding
    val downLoadFragment  = DownloadFragment()
    val secondChoiceFragment = SecondChoiceFragment()
    val firstChoiceFragment = FirstChoiceFragment()
    val updateCurrencyInformation: CalculateFragmentPresenter by activityViewModels()
    var firstNominal = 0
    var firstCurValue = 0.0
    var secondNominal = 0
    var secondCurValue = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCalculateBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        updateCurrencyInformation.firstValuteLiveData.observe(activity as LifecycleOwner, {
            binding.textViewCharCodeFirstCurrency.text = it.charCode
            firstNominal = it.nominal.toInt()
            firstCurValue = it.value.replace(',', '.', false).toDouble()
        })
        updateCurrencyInformation.secondValuteLiveData.observe(activity as LifecycleOwner, {
            binding.textViewCharCodeSecondCurrency.text = it.charCode
            secondNominal = it.nominal.toInt()
            secondCurValue = it.value.replace(',', '.', false).toDouble()
        })

        buttonChangeCurrencyFirst.setOnClickListener {
            firstChoiceFragment.show(parentFragmentManager, FIRST_CHOICE_FRAGMENT_TAG)
            downLoadFragment.show(parentFragmentManager, DOWNLOAD_FRAGMENT_TAG)
            addProgressBar(downLoadFragment)
            clearEditText(editTextFirstCurrency, editTextSecondCurrency)
        }

        buttonChangeCurrencySecond.setOnClickListener {
            secondChoiceFragment.show(parentFragmentManager, SECOND_CHOICE_FRAGMENT_TAG)
            downLoadFragment.show(parentFragmentManager, DOWNLOAD_FRAGMENT_TAG)
            addProgressBar(downLoadFragment)
            clearEditText(editTextFirstCurrency, editTextSecondCurrency)

        }

        editTextFirstCurrency.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val firstFisplayValue = getValueFromScreen(s, requireContext())
                val firstResult = calculationFirstCurrency(
                    firstFisplayValue,
                    firstNominal,
                    firstCurValue,
                    secondNominal,
                    secondCurValue
                )
                textCorrection(s, editTextFirstCurrency, editTextSecondCurrency, firstResult)
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        editTextSecondCurrency.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                val firstFisplayValue = getValueFromScreen(s, requireContext())
                val firstResult = calculationSecondCurrency(
                    firstFisplayValue,
                    firstNominal,
                    firstCurValue,
                    secondNominal,
                    secondCurValue
                )
                textCorrection(s, editTextSecondCurrency, editTextFirstCurrency, firstResult)
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
    }


    companion object{
        const val CALCULATE_FRAGMENT_TAG = "calculate"
        const val FIRST_CHOICE_FRAGMENT_TAG = "first"
        const val SECOND_CHOICE_FRAGMENT_TAG = "second"
        const val DOWNLOAD_FRAGMENT_TAG = "download"
    }

}