package com.ebookfrenzy.lifecycleawarenessapp.ui.main

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.ebookfrenzy.lifecycleawarenessapp.BR.mainViewModel
import com.ebookfrenzy.lifecycleawarenessapp.DemoObserver
import com.ebookfrenzy.lifecycleawarenessapp.MainActivity
import com.ebookfrenzy.lifecycleawarenessapp.databinding.FragmentMainBinding
import com.ebookfrenzy.lifecycleawarenessapp.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        lifecycle.addObserver(DemoObserver())

        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.lifecycleOwner = MainActivity()
        return binding.root
    }

    var content = "Here"

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.output.text = (binding.output.text.toString() + "\n" + DemoObserver().text)
        action()

        binding.setVariable(mainViewModel, viewModel)
    }

    @SuppressLint("SetTextI18n")
    private fun action()
    {
        if (binding.output.text.isNotEmpty()) {
            viewModel.displays(content)
            binding.output.text = viewModel.results()
        } else {
            binding.output.text = "No names to display"
        }
    }

}