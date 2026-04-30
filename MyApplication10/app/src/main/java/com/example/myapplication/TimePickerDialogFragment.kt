package com.example.myapplication

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class TimePickerDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        return TimePickerDialog(
            requireContext(),
            { _, hourOfDay, minuteOfDay ->
                (activity as MainActivity).updateResult("Установлено время $hourOfDay:$minuteOfDay")
            },
            hour,
            minute,
            true
        )
    }
}