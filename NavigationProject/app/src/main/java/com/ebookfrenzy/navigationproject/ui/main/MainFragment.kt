package com.ebookfrenzy.navigationproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ebookfrenzy.navigationproject.R
import com.ebookfrenzy.navigationproject.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.displayImage1.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond =
                MainFragmentDirections.mainToSecond()
            action.message = "Image 1"
            action.image = R.drawable.android_image_1.toString()
            Navigation.findNavController(it).navigate(action)
        }
        binding.displayImage2.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond =
                MainFragmentDirections.mainToSecond()
            action.message = "Image 2"
            action.image = R.drawable.android_image_2.toString()
            Navigation.findNavController(it).navigate(action)
        }
        binding.displayImage3.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond =
                MainFragmentDirections.mainToSecond()
            action.message = "Image 3"
            action.image = R.drawable.android_image_3.toString()
            Navigation.findNavController(it).navigate(action)
        }
    }
}