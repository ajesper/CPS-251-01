package com.ebookfrenzy.lifecycleawarenessapp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {

    companion object {
        private var message: MutableLiveData<String> = MutableLiveData()

        private var mess = ""
        fun addMsg(msg: String){
            mess += msg
            message.value = mess
        }
    }

    fun getMsg(): MutableLiveData<String> {
        return message
    }
}