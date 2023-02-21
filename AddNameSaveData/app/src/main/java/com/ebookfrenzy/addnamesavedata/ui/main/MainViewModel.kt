package com.ebookfrenzy.addnamesavedata.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel()
{
    private var names = ""
    private var result = "No names to display"
    fun addName(value: String)
    {
        this.names = value
        result = if(result == "No names to display")
        {
            names
        } else
        {
            result + "\n" + names
        }
    }
    fun getNames(): String
    {
        return result
    }
}