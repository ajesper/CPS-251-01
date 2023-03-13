package com.ebookfrenzy.lifecycleawarenessapp

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import java.util.*
import com.ebookfrenzy.lifecycleawarenessapp.ui.main.MainFragment

class DemoObserver: DefaultLifecycleObserver {
    private val _logTag = "DemoObserver"
    private lateinit var myFragment: MainFragment
    var text = "One first"

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        myFragment = MainFragment.newInstance()
        val call = Calendar.getInstance()
        myFragment.content = "I am here"
        Log.i(_logTag, ("onResume was fired on " + "%02d".format(call.get(Calendar.HOUR)) + ":" + "%02d".format(call.get(Calendar.MINUTE)) + ":" + "%02d".format(call.get(Calendar.SECOND)) + "." + "%03d".format(call.get(Calendar.MILLISECOND)) + "**********"))
    }
    override fun onPause(owner: LifecycleOwner){
        super.onPause(owner)
        val call = Calendar.getInstance()
        Log.i(_logTag, ("onPause was fired on " + "%02d".format(call.get(Calendar.HOUR)) + ":" + "%02d".format(call.get(Calendar.MINUTE)) + ":" + "%02d".format(call.get(Calendar.SECOND)) + "." + "%03d".format(call.get(Calendar.MILLISECOND)) + "**********"))
    }
    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        val call = Calendar.getInstance()

        Log.i(_logTag, ("onCreate was fired on " + "%02d".format(call.get(Calendar.HOUR)) + ":" + "%02d".format(call.get(Calendar.MINUTE)) + ":" + "%02d".format(call.get(Calendar.SECOND)) + "." + "%03d".format(call.get(Calendar.MILLISECOND))))
    }
    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        val call = Calendar.getInstance()
        Log.i(_logTag, ("onStart was fired on " + "%02d".format(call.get(Calendar.HOUR)) + ":" + "%02d".format(call.get(Calendar.MINUTE)) + ":" + "%02d".format(call.get(Calendar.SECOND)) + "." + "%03d".format(call.get(Calendar.MILLISECOND))))
    }
    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        val call = Calendar.getInstance()
        Log.i(_logTag, ("onStop was fired on " + "%02d".format(call.get(Calendar.HOUR)) + ":" + "%02d".format(call.get(Calendar.MINUTE)) + ":" + "%02d".format(call.get(Calendar.SECOND)) + "." + "%03d".format(call.get(Calendar.MILLISECOND))))
    }
    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        val call = Calendar.getInstance()
        Log.i(_logTag, ("onDestroy was fired on " + "%02d".format(call.get(Calendar.HOUR)) + ":" + "%02d".format(call.get(Calendar.MINUTE)) + ":" + "%02d".format(call.get(Calendar.SECOND)) + "." + "%03d".format(call.get(Calendar.MILLISECOND)) + "**********"))
    }
}