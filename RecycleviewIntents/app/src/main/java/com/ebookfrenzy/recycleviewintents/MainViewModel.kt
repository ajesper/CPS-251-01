package com.ebookfrenzy.recycleviewintents

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var message: ArrayList<Data> = ArrayList()

    fun addToArray(data: Data){

        message.add(data)
    }

    fun getArray(): ArrayList<Data> {
        return message
    }
}