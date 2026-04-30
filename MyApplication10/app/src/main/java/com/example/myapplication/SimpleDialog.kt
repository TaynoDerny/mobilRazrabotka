package com.example.myapplication

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class SimpleDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            AlertDialog.Builder(it)
                .setMessage("Это пустое диалоговое окно")
                .setPositiveButton("Понятно", null)
                .create()
        } ?: throw IllegalArgumentException("Activity cannot be null")
    }
}