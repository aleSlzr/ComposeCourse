package com.example.composecourse

data class CheckboxObject(
    val title: String,
    var selected: Boolean = false,
    var onCheckedChange: (Boolean) -> Unit
)
