package com.ebookfrenzy.coroutineproject

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class MainViewModel : ViewModel() {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun performTask(name: String, adapter: RecyclerAdapter) {
        coroutineScope.launch(Dispatchers.Main) {
            val result = computeResult(name)
            adapter.addData(result)
        }
    }

    private suspend fun computeResult(name: String): String {
        val time = (1..10).random() * 1000L
        delay(time)
        return "The name is $name and the delay was $time milliseconds"
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}