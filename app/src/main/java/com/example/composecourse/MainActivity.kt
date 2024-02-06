package com.example.composecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.composecourse.ui.theme.ComposeCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCourseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {

                }
            }
        }
    }
}

/*var myText by remember { mutableStateOf("") }
Column {
    MyTextFieldStateless(myText) { myText = it }
}
val myOptions = getOptions(listOf("perro", "gato", "raton"))
var selected by rememberSaveable { mutableStateOf("1") }
Column {
    myOptions.forEach {
        CheckboxMultipleInstances(it)
    }
    //MyCheckboxWithText()
    //MyRadioButton()
    //MyRadioButtonAdvance(selected) { selected = it }
    MyCard()
    MyBadgeBox()
    MyDropdownMenu()
    MySlider()
    MySliderAdvanced()
    var showDialog by rememberSaveable {
        mutableStateOf(false)
    }
    Button(onClick = { showDialog = true }) {
        Text(text = "Show dialog")
    }
    MyAlertDialog(
        showDialog = showDialog,
        onDismiss = { showDialog = false },
        onConfirm = { showDialog = false }
    )
    MyPersonalizedDialog(
        showDialog = showDialog,
        onDismiss = { showDialog = false },
        onConfirm = { showDialog = false }
    )
    MyCustomComplexDialog(
        showDialog = showDialog,
        onDismiss = { showDialog = false }
    )
    MyConfirmationDialog(
        showDialog = showDialog,
        onDismiss = { showDialog = false }
    )
}*/
