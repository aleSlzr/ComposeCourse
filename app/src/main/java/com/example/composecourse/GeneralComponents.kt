package com.example.composecourse

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TriStateCheckbox
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
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun MyDropdownMenu() {
    var selectedText by rememberSaveable { mutableStateOf("") }
    var expanded by rememberSaveable { mutableStateOf(false) }
    val desserts = listOf("Helado", "Cafe", "Galletas", "Pastel")

    Column(modifier = Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            desserts.forEach { dessert ->
                DropdownMenuItem(text = {
                    Text(text = dessert)
                }, onClick = {
                    expanded = false
                    selectedText = dessert
                })
            }
        }
    }
}

@Composable
fun MyDivider() {
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), color = Color.Red
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBadgeBox() {
    BadgedBox(badge = {
        Badge(
            modifier = Modifier.wrapContentWidth(),
            containerColor = Color.Cyan
        ) {
            Text(text = "888")
        }
    }, modifier = Modifier.padding(16.dp)) {
        Icon(imageVector = Icons.Default.Star, contentDescription = "")
    }
}

@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        shape = MaterialTheme.shapes.extraLarge,
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray,
            contentColor = Color.Red
        ),
        border = BorderStroke(5.dp, Color.Cyan)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "ejemplo 1")
            Text(text = "ejemplo 2")
            Text(text = "ejemplo 3")
        }
    }
}

@Composable
fun MyRadioButtonAdvance(name: String, onItemSelected: (String) -> Unit) {
    Column(Modifier.fillMaxWidth()) {
        Row {
            RadioButton(selected = name == "1", onClick = { onItemSelected("1") })
            Text(text = "1", modifier = Modifier.padding(top = 12.dp))
        }
        Row {
            RadioButton(selected = name == "2", onClick = { onItemSelected("2") })
            Text(text = "2", modifier = Modifier.padding(top = 12.dp))
        }
        Row {
            RadioButton(selected = name == "3", onClick = { onItemSelected("3") })
            Text(text = "3", modifier = Modifier.padding(top = 12.dp))
        }
        Row {
            RadioButton(selected = name == "4", onClick = { onItemSelected("4") })
            Text(text = "4", modifier = Modifier.padding(top = 12.dp))
        }
    }
}

@Composable
fun MyRadioButton() {
    Row(Modifier.fillMaxWidth()) {
        RadioButton(
            selected = false, onClick = {}, colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Blue,
                disabledSelectedColor = Color.Green
            )
        )
        Text(text = "Radio button example", modifier = Modifier.padding(top = 12.dp))
    }
}

@Composable
fun MyTryStateCheckbox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.On -> {
                ToggleableState.Off
            }

            ToggleableState.Off -> {
                ToggleableState.Indeterminate
            }

            ToggleableState.Indeterminate -> {
                ToggleableState.On
            }
        }
    })
}

@Composable
fun getOptions(titles: List<String>): List<CheckboxObject> {
    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckboxObject(
            title = it,
            selected = status,
            onCheckedChange = { boxStatus -> status = boxStatus }
        )
    }
}

@Composable
fun CheckboxMultipleInstances(checkboxObject: CheckboxObject) {
    Row(Modifier.padding(8.dp)) {
        Checkbox(
            checked = checkboxObject.selected,
            onCheckedChange = { checkboxObject.onCheckedChange(!checkboxObject.selected) })
        Text(text = checkboxObject.title, Modifier.padding(top = 12.dp))
    }
}

@Composable
fun MyCheckboxWithText() {
    var checked by rememberSaveable { mutableStateOf(false) }

    Row(Modifier.padding(8.dp)) {
        Checkbox(checked = checked, onCheckedChange = { checked = !checked })
        Text(text = "Ejemplo 1", Modifier.padding(top = 12.dp))
    }
}

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

@Composable
fun MyProgress() {
    var showProgress by rememberSaveable { mutableStateOf(false) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 24.dp),
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

@Composable
fun MyIcon() {
    Icon(imageVector = Icons.Outlined.Star, contentDescription = "icono", tint = Color.Red)
}

@Composable
fun MyImageAdvance() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        modifier = Modifier
            .clip(CircleShape)
            .border(5.dp, Color.Red, CircleShape),
    )
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        modifier = Modifier.alpha(0.5f),
    )
}

@Composable
fun MyButton() {
    var enabled by rememberSaveable { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
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

@Composable
fun MyTextField() {
    var myText by remember { mutableStateOf("") }
    TextField(value = myText, onValueChange = { myText = it })
}

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

@Composable
fun MyConstraintLayout() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (red, blue, yellow, magenta, cyan) = createRefs()
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(red) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Blue)
            .constrainAs(blue) {
                top.linkTo(red.bottom)
                end.linkTo(red.start)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Yellow)
            .constrainAs(yellow) {
                bottom.linkTo(red.top)
                end.linkTo(red.start)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Magenta)
            .constrainAs(magenta) {
                bottom.linkTo(red.top)
                start.linkTo(red.end)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Cyan)
            .constrainAs(cyan) {
                top.linkTo(red.bottom)
                start.linkTo(red.end)
            })
    }
}

@Composable
fun MyComplexLayout() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan)
        ) {

        }
        MySpacer(size = 30)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red)
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green), contentAlignment = Alignment.Center
            ) {
                Text(text = "Hola mundo")
            }
        }
        MySpacer(size = 80)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta)
        )
    }
}

@Composable
fun MySpacer(size: Int) {
    Spacer(modifier = Modifier.height(size.dp))
}