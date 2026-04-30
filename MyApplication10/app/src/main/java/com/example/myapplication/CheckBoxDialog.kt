package com.example.myapplication

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class CheckBoxDialog : DialogFragment() {
    private val langs = arrayOf("Java", "Kotlin", "C++", "Python")
    private val checked = booleanArrayOf(true, true, false, false)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            AlertDialog.Builder(it)
                .setMultiChoiceItems(langs, checked) { _, which, isChecked ->
                    checked[which] = isChecked
                }
                .setPositiveButton("OK") { _, _ ->
                    val count = checked.count { it }
                    (activity as MainActivity).updateResult("Выбрано языков: $count")
                }
                .create()
        } ?: throw IllegalArgumentException("Activity cannot be null")
    }
}