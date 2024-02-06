package com.example.composecourse

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MySlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by rememberSaveable { mutableStateOf(0f) }
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
        Text(text = sliderPosition.toString())
    }
}

@Composable
fun MySliderAdvanced() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by rememberSaveable { mutableStateOf(0f) }
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            onValueChangeFinished = {  },
            valueRange = 0f..10f,
            steps = 9
        )
        Text(text = sliderPosition.toString())
    }
}

