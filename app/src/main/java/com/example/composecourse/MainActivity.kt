package com.example.composecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    var myText by remember { mutableStateOf("") }
                    /*Column {
                        MyTextFieldStateless(myText) { myText = it }
                    }*/
                    MyCheckboxWithText()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyCheckboxWithText() {
    var checked by rememberSaveable { mutableStateOf(false) }

    Row(Modifier.padding(8.dp)) {
        Checkbox(checked = checked, onCheckedChange = { checked = !checked })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Ejemplo 1")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyProgressAdvance() {
    var increment by rememberSaveable { mutableStateOf(0f) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CircularProgressIndicator(progress = increment)
        Row(Modifier.fillMaxWidth()) {
            Button(onClick = { increment += 0.1f }) {
                Text(text = "Incrementar")
            }

            Button(onClick = { increment -= 0.1f }) {
                Text(text = "Decrementar")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyProgress() {
    var showProgress by rememberSaveable { mutableStateOf(false) }
    Column(
        Modifier.fillMaxSize().padding(top = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = { showProgress = !showProgress }) {
            Text(text = "Show loaders")
        }
        if (showProgress) {
            CircularProgressIndicator(color = Color.Cyan, strokeWidth = 5.dp)
            LinearProgressIndicator(
                color = Color.Red,
                trackColor = Color.Yellow,
                modifier = Modifier.padding(top = 32.dp),
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyIcon() {
    Icon(imageVector = Icons.Outlined.Star, contentDescription = "icono", tint = Color.Red)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyImageAdvance() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        modifier = Modifier.clip(CircleShape).border(5.dp, Color.Red, CircleShape),
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        modifier = Modifier.alpha(0.5f),
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyButton() {
    var enabled by rememberSaveable { mutableStateOf(true) }
    Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
        Button(
            onClick = { enabled = false },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Cyan,
                contentColor = Color.Red,
            ),
            border = BorderStroke(5.dp, Color.Green),
        ) {
            Text(text = "Text")
        }
    }
}

@Composable
fun MyTextFieldStateless(name: String, onValueChange: (String) -> Unit) {
    TextField(value = name, onValueChange = { onValueChange(it) })
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyTextFieldOutlined() {
    var myText by remember { mutableStateOf("") }

    OutlinedTextField(
        value = myText,
        onValueChange = {
            myText = if (it.contains("a")) {
                it.replace("a", "")
            } else {
                it
            }
        },
        label = { Text(text = "Introduce tu nombre") },
        modifier = Modifier.padding(24.dp),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Cyan,
            unfocusedIndicatorColor = Color.Blue,
        ),
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyTextFieldAdvance() {
    var myText by remember { mutableStateOf("") }

    TextField(
        value = myText,
        onValueChange = {
            myText = if (it.contains("a")) {
                it.replace("a", "")
            } else {
                it
            }
        },
        label = { Text(text = "Introduce tu nombre") },
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyTextField() {
    var myText by remember { mutableStateOf("") }
    TextField(value = myText, onValueChange = { myText = it })
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo")
        Text(text = "Esto es un ejemplo", color = Color.Blue)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.Light)
        Text(text = "Esto es un ejemplo", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(
            text = "Esto es un ejemplo",
            textDecoration = TextDecoration.LineThrough,
        )
        Text(
            text = "Esto es un ejemplo",
            textDecoration = TextDecoration.Underline,
        )
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.Underline, TextDecoration.LineThrough),
                ),
            ),
        )
        Text(text = "Esto es un ejemplo", fontSize = 30.sp)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyStateExample() {
    var counter by rememberSaveable { mutableStateOf(0) }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = { counter += 1 }) {
            Text(text = "Pulsar")
        }
        Text(text = "He sido presionado $counter veces")
    }
}
