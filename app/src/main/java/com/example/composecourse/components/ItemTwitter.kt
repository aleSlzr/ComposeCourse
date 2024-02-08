package com.example.composecourse.components

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecourse.R

@Preview(showSystemUi = true)
@Composable
fun ItemTwitter() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xE8090C22))
            .padding(20.dp)
    ) {
        Column(horizontalAlignment = Alignment.Start, modifier = Modifier.padding(end = 15.dp)) {
            ProfileImageItem()
        }
        Column {
            TwitContentHeader()
            Spacer(modifier = Modifier.height(5.dp))
            TwitContentDescription()
            Spacer(modifier = Modifier.height(5.dp))
            TwitContentImage()
            TwitContentActions()
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun TwitContentActions() {
    var chatCounter by remember { mutableStateOf(false) }
    var likeCounter by remember { mutableStateOf(false) }
    var reTwitCounter by remember { mutableStateOf(false) }

    Row(modifier = Modifier.fillMaxWidth()) {
        IconButton(onClick = {
            chatCounter = !chatCounter
        }) {
            Icon(
                painter = if (chatCounter) painterResource(id = R.drawable.ic_chat_filled) else painterResource(id = R.drawable.ic_chat),
                contentDescription = "Chat",
                tint = if (chatCounter) Color.Cyan else Color.LightGray,
                modifier = Modifier
                    .weight(1f)
                    .size(24.dp)
            )
        }
        Text(
            text = if (chatCounter) "2" else "1",
            color = Color.LightGray,
            fontSize = 10.sp,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(1f)
        )
        IconButton(onClick = {
            reTwitCounter = !reTwitCounter
        }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_rt),
                contentDescription = "Retwit",
                tint = if (reTwitCounter) Color.Green else Color.LightGray,
                modifier = Modifier
                    .weight(1f)
                    .size(24.dp)
            )
        }
        Text(
            text = if (reTwitCounter) "2" else "1",
            color = Color.LightGray,
            fontSize = 10.sp,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(1f)
        )
        IconButton(onClick = {
            likeCounter = !likeCounter
        }) {
            Icon(
                painter = if (likeCounter) painterResource(id = R.drawable.ic_like_filled) else painterResource(id = R.drawable.ic_like),
                contentDescription = "Like",
                tint = if (likeCounter) Color.Red else Color.LightGray,
                modifier = Modifier
                    .weight(1f)
                    .size(24.dp)
            )
        }
        Text(
            text = if (likeCounter) "2" else "1",
            color = Color.LightGray,
            fontSize = 10.sp,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(1f)
        )
    }
}

@Composable
fun TwitContentImage() {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "Image content",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .height(200.dp)
    )
}

@Composable
fun TwitContentDescription() {
    Text(
        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
            "Sed pharetra maximus tincidunt." +
            "Proin id porta sapien, non dictum purus." +
            "Vivamus et volutpat sapien.",
        color = Color.White,
        fontSize = 15.sp,
        fontWeight = FontWeight.Medium
    )
}

@Composable
fun TwitContentHeader() {
    Row(
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = "Ale",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 18.sp,
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = "@aliaSlzr",
            fontSize = 18.sp,
            color = Color.LightGray,
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = "4h",
            fontSize = 18.sp,
            color = Color.LightGray
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id = R.drawable.ic_dots),
            contentDescription = "Twit Details",
            tint = Color.White
        )
    }
}

@Composable
fun ProfileImageItem() {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "Profile image",
        modifier = Modifier
            .clip(CircleShape)
            .size(80.dp)
    )
}
