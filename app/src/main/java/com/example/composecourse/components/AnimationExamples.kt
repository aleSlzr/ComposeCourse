package com.example.composecourse.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Sensors
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random.Default.nextInt

@Composable
fun ColorAnimationSimple() {
    Column {
        var colorAnimation by rememberSaveable { mutableStateOf(false) }
        var showBox by rememberSaveable {
            mutableStateOf(true)
        }
        val realColor by animateColorAsState(
            targetValue = if (colorAnimation) Color.Blue else Color.Yellow,
            animationSpec = tween(durationMillis = 2000),
            finishedListener = { showBox = false }
        )
        if (showBox) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(realColor)
                    .clickable { colorAnimation = !colorAnimation })
        }
    }
}

@Composable
fun SizeAnimation() {
    var smallSize by rememberSaveable { mutableStateOf(true) }
    val size by animateDpAsState(
        targetValue = if (smallSize) 50.dp else 200.dp,
        animationSpec = tween(durationMillis = 500),
        finishedListener = { }
    )
    Box(
        modifier = Modifier
            .size(size)
            .background(Color.Cyan)
            .clickable { smallSize = !smallSize }
    )
}

@Composable
fun VisibilityAnimation() {
    var isVisible by rememberSaveable { mutableStateOf(true) }
    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "show/hide")
        }
        Spacer(modifier = Modifier.size(50.dp))
        AnimatedVisibility(
            isVisible,
            enter = slideInHorizontally(),
            exit = slideOutHorizontally()
        ) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(Color.Red)
            )
        }
    }
}

enum class ComponentType() {
    Image, Text, Box, Error
}

@Composable
fun CrossFadeExampleAnimation() {
    var myComponentType: ComponentType by rememberSaveable {
        mutableStateOf(ComponentType.Text)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = { myComponentType = getComponentTypeRandom() }) {
            Text(text = "Change component")
        }
        Crossfade(targetState = myComponentType, label = "") {
            when (it) {
                ComponentType.Box -> Box(modifier = Modifier
                    .size(150.dp)
                    .background(Color.Green))
                ComponentType.Image -> Icon(Icons.Default.Sensors, contentDescription = "")
                ComponentType.Text -> Text(text = "Text component")
                ComponentType.Error -> Text(text = "Error message")
            }
        }
    }
}

fun getComponentTypeRandom(): ComponentType {
    return when(nextInt(from = 0, until = 3)) {
        0 -> ComponentType.Text
        1 -> ComponentType.Box
        2 -> ComponentType.Image
        else -> ComponentType.Error
    }
}
