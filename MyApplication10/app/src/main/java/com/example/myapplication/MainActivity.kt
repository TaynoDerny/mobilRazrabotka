package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvResult = findViewById<TextView>(R.id.tvResult)

        findViewById<TextView>(R.id.tvSimple).setOnClickListener {
            SimpleDialog().show(supportFragmentManager, "simple")
        }

        findViewById<TextView>(R.id.tvRadio).setOnClickListener {
            RadioDialog().show(supportFragmentManager, "radio")
        }

        findViewById<TextView>(R.id.tvCheck).setOnClickListener {
            CheckBoxDialog().show(supportFragmentManager, "check")
        }

        findViewById<TextView>(R.id.tvTime).setOnClickListener {
            TimePickerDialogFragment().show(supportFragmentManager, "time")
        }
    }

    fun updateResult(text: String) {
        findViewById<TextView>(R.id.tvResult).text = text
    }
}