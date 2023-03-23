package com.ebookfrenzy.recycleviewproject

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var message: ArrayList<Data> = ArrayList()

    fun addToArray(data: Data, i: Int){

        message.add(i, data)
    }

    fun getArray(): ArrayList<Data> {
        return message
    }
}
