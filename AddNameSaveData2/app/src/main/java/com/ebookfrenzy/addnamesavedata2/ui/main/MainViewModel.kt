package com.ebookfrenzy.addnamesavedata2.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel()
{
    var names: MutableLiveData<String> = MutableLiveData()
    var result: MutableLiveData<String> = MutableLiveData()

    fun displayNames() {
        names.let {
            if (!it.value.equals("")) {
                if (!result.value.equals(null))
                {
                    result.value = result.value + "\n" + it.value
                }
                else
                {
                    result.value = it.value
                }
            } else {
                result.value = "No names to display"
            }
        }
    }
}