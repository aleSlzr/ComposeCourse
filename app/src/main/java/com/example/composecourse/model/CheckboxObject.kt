package com.example.composecourse.model

data class CheckboxObject(
    val title: String,
    var selected: Boolean = false,
    var onCheckedChange: (Boolean) -> Unit
)
