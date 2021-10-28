package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.example.myapplication.ui.main.MainFragment

class MainActivity : AppCompatActivity() {
    val API_KEY = "asbcdjas"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commit()
        }
    }

    var restored = false
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        outState.putBoolean("restored", true)
        super.onSaveInstanceState(outState, outPersistentState)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("restored")) {
                restored = savedInstanceState.getBoolean("restored")
            }
        }
        super.onRestoreInstanceState(savedInstanceState)
    }

//    protected fun onRestoreInstanceState(savedInstanceState: Bundle?) {
//        if (savedInstanceState != null) {
//            if (savedInstanceState.containsKey("restored")) {
//                restored = savedInstanceState.getBoolean("restored")
//            }
//        }
//        super.onRestoreInstanceState(savedInstanceState!!)
//    }
}