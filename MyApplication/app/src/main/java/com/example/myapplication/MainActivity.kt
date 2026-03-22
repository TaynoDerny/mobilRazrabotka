package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import android.util.Log
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    val TAG = "LifecycleDemo"

    fun showMessage(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
        Log.d(TAG, s)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Для Compose проектов:
        setContentView(android.widget.TextView(this).apply {
            text = "Наблюдай за тостами и логами!"
            textSize = 20f
        })

        showMessage("🟢 onCreate вызван")
    }

    override fun onStart() {
        super.onStart()
        showMessage("🟡 onStart вызван")
    }

    override fun onResume() {
        super.onResume()
        showMessage("🟢 onResume вызван")
    }

    override fun onPause() {
        super.onPause()
        showMessage("🟠 onPause вызван")
    }

    override fun onStop() {
        super.onStop()
        showMessage("🔴 onStop вызван")
    }

    override fun onDestroy() {
        super.onDestroy()
        showMessage("⚫ onDestroy вызван")
    }

    override fun onRestart() {
        super.onRestart()
        showMessage("🔵 onRestart вызван")
    }
}