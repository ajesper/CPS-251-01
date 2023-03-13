package com.ebookfrenzy.lifecycleawarenessapp.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var text = "Vengeance will be mine"
    private var result = "Hi"
    fun displays(value: String) {
        this.text = value
        result = if (result != "") {
            result + "\n" + text
        } else {
            text
        }
    }

    fun results(): String
    {
        return result
    }
}