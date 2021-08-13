package com.example.currencyconverter.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.currencyconverter.R
import com.example.currencyconverter.databinding.ActivityMainBinding
import com.example.currencyconverter.screens.calculate.CalculateFragment
import com.example.currencyconverter.screens.choice.first.FirstChoiceFragment
import com.example.currencyconverter.screens.download.DownloadFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val calculateFragment = CalculateFragment()
        supportFragmentManager.beginTransaction().add(R.id.container, calculateFragment).commit()
    }
}