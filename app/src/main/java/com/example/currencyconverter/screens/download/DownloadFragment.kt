package com.example.currencyconverter.screens.download

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.currencyconverter.R
import com.example.currencyconverter.databinding.FragmentDownloadBinding


class DownloadFragment  : DialogFragment() {

    lateinit var binding : FragmentDownloadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDownloadBinding.inflate(inflater)

        return binding.root
    }

}