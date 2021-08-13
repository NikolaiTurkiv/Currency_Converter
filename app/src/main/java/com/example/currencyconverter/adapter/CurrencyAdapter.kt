package com.example.currencyconverter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyconverter.R
import com.example.currencyconverter.pojo.Valute
import kotlinx.android.synthetic.main.adapter.view.*

class CurrencyAdapter : RecyclerView.Adapter<CurrencyAdapter.CurrencyAdapterViewHolder>() {

    var currencys: MutableList<Valute> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var onCurrencyClickListener: SetOnCurrencyClickListener? = null

    inner class CurrencyAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val currencyName = itemView.textViewCurrencyName
        val currencyCharCode = itemView.textViewCharCode
        val checkIcon = itemView.imageViewCheck
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter, parent, false)
        return CurrencyAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CurrencyAdapterViewHolder, position: Int) {
        val currency = currencys[position]
        with(holder) {
            currencyName.text = currency.name
            currencyCharCode.text = currency.charCode
            if (!currency.checked) {
                checkIcon.visibility = View.INVISIBLE
            } else {
                checkIcon.visibility = View.VISIBLE
            }
            itemView.setOnClickListener{
                onCurrencyClickListener?.onCurrencyClick(position)
                it.isClickable
            }
        }
    }

    interface SetOnCurrencyClickListener {
        fun onCurrencyClick(position: Int)
    }

    override fun getItemCount(): Int {
        return currencys.size
    }
}