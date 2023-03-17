package com.ebookfrenzy.lifecycleawarenessapp

import android.util.Log
import androidx.lifecycle.*
import com.ebookfrenzy.lifecycleawarenessapp.ui.main.MainViewModel
import java.time.LocalTime

class DemoObserver: DefaultLifecycleObserver {
    private val tag = "DemoObserver"

    private var mv = MainViewModel

    private fun getDateTime():String {
        return LocalTime.now().toString()

    }

    override fun onResume(owner: LifecycleOwner) {
        Log.i(tag,"onResume")
        mv.addMsg("onResume was fired on " + getDateTime() + "\n**********\n")
    }

    override fun onPause(owner: LifecycleOwner) {
        Log.i(tag, "onPause")
        mv.addMsg("onPause was fired on " + getDateTime() + "\n**********\n")
    }

    override fun onCreate(owner: LifecycleOwner) {
        Log.i(tag, "onCreate\n")
        mv.addMsg("onCreate was fired on " + getDateTime() + "\n")
    }

    override fun onStart(owner: LifecycleOwner) {
        Log.i(tag, "onStart")
        mv.addMsg("onStart was fired on " + getDateTime() + "\n")

    }

    override fun onStop(owner: LifecycleOwner) {
        Log.i(tag, "onStop")
        mv.addMsg("onStop was fired on " + getDateTime() + "\n")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        Log.i(tag, "onDestroy")
        mv.addMsg("onDestroy was fired on " + getDateTime() + "\n**********\n")
    }
}