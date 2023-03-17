package com.ebookfrenzy.lifecycleawarenessapp.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ebookfrenzy.lifecycleawarenessapp.DemoObserver
import com.ebookfrenzy.lifecycleawarenessapp.databinding.FragmentMainBinding
import androidx.lifecycle.Observer

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var out:TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        out = binding.output
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        lifecycle.addObserver(DemoObserver())
        val messageObserver = Observer<String> {
                result -> binding.output.text = result.toString()
        }
        viewModel.getMsg().observe(viewLifecycleOwner, messageObserver)
    }

}