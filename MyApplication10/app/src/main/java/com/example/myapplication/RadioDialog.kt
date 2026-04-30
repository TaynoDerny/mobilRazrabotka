package com.example.myapplication

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class RadioDialog : DialogFragment() {
    private val langs = arrayOf("Java", "Kotlin", "C++", "Python")
    private var choice = 1

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            AlertDialog.Builder(it)
                .setSingleChoiceItems(langs, choice) { dialog, which ->
                    choice = which
                    (activity as MainActivity).updateResult("Выбрано: ${langs[which]}")
                    dialog.dismiss()
                }
                .create()
        } ?: throw IllegalArgumentException("Activity cannot be null")
    }
}