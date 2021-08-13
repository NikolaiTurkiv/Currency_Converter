package com.example.currencyconverter.screens.choice.second

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currencyconverter.screens.calculate.CalculateFragmentPresenter
import com.example.currencyconverter.adapter.CurrencyAdapter
import com.example.currencyconverter.addToolBar
import com.example.currencyconverter.databinding.FragmentSecondChoiceBinding
import com.example.currencyconverter.pojo.Valute
import com.example.currencyconverter.screens.choice.ChoiceCurrencyListPresenter
import com.example.currencyconverter.screens.choice.ChoiceCurrencyListView
import kotlinx.android.synthetic.main.fragment_second_choice.*
import kotlinx.android.synthetic.main.toolbar.*


class SecondChoiceFragment : DialogFragment(),ChoiceCurrencyListView {

    private lateinit var adapter: CurrencyAdapter
    private lateinit var presenter : ChoiceCurrencyListPresenter
    lateinit var binding: FragmentSecondChoiceBinding
    val updateCurrencyInformation: CalculateFragmentPresenter by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = CurrencyAdapter()
        presenter = ChoiceCurrencyListPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondChoiceBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView = RecyclerViewSecondChoice
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
        presenter.loadData()
        addToolBar(toolbar,this)
    }

    override fun onStart() {
        super.onStart()
        adapter.onCurrencyClickListener = object : CurrencyAdapter.SetOnCurrencyClickListener {
            override fun onCurrencyClick(position: Int) {
                if (!adapter.currencys[position].checked) {
                    adapter.currencys[position].checked = true
                    adapter.notifyDataSetChanged()
                    updateCurrencyInformation.secondValuteLiveData.value =
                        adapter.currencys[position]
                }
                dismiss()
            }
        }
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        presenter.dispose()
    }

    override fun showData(mutableList: MutableList<Valute>) {
        adapter.currencys.addAll(mutableList)
        adapter.notifyDataSetChanged()
    }

    override fun onError() {
        Toast.makeText(context,"Ошбка загрузки данных",Toast.LENGTH_LONG).show()
    }
}