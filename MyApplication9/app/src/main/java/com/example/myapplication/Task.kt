package com.example.myapplication

data class Task(
    val title: String,
    val description: String,
    var isCompleted: Boolean = false
)