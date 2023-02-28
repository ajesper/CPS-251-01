package com.ebookfrenzy.addnamesavedata.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel()
{
    private var names = ""
    private var result: MutableLiveData<String> = MutableLiveData()

    fun addName(value: String)
    {
        this.names = (value)
        if(result.value == null)
        {
            result.setValue(names)
        } else
        {
            result.setValue(result.value + "\n" + names)
        }
    }
    fun getNames(): MutableLiveData<String>
    {
        return result
    }
}