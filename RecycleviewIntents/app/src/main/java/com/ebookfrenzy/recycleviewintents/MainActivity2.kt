package com.ebookfrenzy.recycleviewintents

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ebookfrenzy.recycleviewintents.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras ?: return

        val myTitle = extras.getString("title")

        val myDetail = extras.getString("detail")

        val myImage = extras.getInt("image")

        binding.argText.text = myTitle
        binding.textViewDiscr.text = myDetail
        binding.imageView4.setImageResource(myImage)

    }
}