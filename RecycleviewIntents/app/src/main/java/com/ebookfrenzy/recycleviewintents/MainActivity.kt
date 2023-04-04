package com.ebookfrenzy.recycleviewintents

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.recycleviewintents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        layoutManager = LinearLayoutManager(this)
        binding.contentMain.recyclerView.layoutManager = layoutManager
        adapter = RecyclerAdapter()
        binding.contentMain.recyclerView.adapter = adapter
    }

    companion object fun buttonPress(view: View)
    {
        val i = Intent(this, MainActivity2::class.java)

        val myTitle = "Go"//itemTitle.text

        val myDetail = "far far away"//itemDetail.text

        val myImage = R.drawable.android_image_1//itemImage.toString().toInt()

        i.putExtra("title", myTitle)
        i.putExtra("detail", myDetail)
        i.putExtra("image", myImage)

        startActivity(i)
    }
}