package com.ebookfrenzy.tipcalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ebookfrenzy.tipcalculator.databinding.ActivityMainBinding
import java.math.RoundingMode

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    @SuppressLint("SetTextI18n")
    fun calcTip(@Suppress("UNUSED_PARAMETER")view: View)
    {
        if (binding.billTotal.text.isNotEmpty())
        {
            val dollarValue = binding.billTotal.text.toString().toFloat()
            val tenP = dollarValue * 1.10f
            val fifteenP = dollarValue * 1.15f
            val twentyP = dollarValue * 1.20f
            val tip = ("The tips are as follows:\n\n10% = " + tenP.toBigDecimal().setScale(2, RoundingMode.HALF_UP).toString() +
                    "\n15% = " + fifteenP.toBigDecimal().setScale(2, RoundingMode.HALF_UP).toString() + "\n20% = " +
                    twentyP.toBigDecimal().setScale(2, RoundingMode.HALF_UP).toString())
            binding.textView.text = tip
        } else
        {
            binding.textView.text = "YOU MUST ENTER A BILL AMOUNT"
        }
    }
}