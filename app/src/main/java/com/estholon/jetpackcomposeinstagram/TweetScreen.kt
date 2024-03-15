package com.estholon.jetpackcomposeinstagram

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.DefaultTintColor
import androidx.compose.ui.layout.ContentScale

@Composable
fun Tweet(){
    Column(Modifier.fillMaxSize().background(Color.Black)) {
        TweetBody()
        Spacer(modifier = Modifier.size(8.dp))
        TweetFooter()
        Spacer(modifier = Modifier.size(16.dp))
        MyDivider()
    }
}

@Composable
fun TweetBody() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Account",
            modifier = Modifier
                .clip(shape = CircleShape)
                .size(100.dp)
        )
        TweetDetail()
    }
}

@Composable
fun TweetDetail() {
    Column(
        Modifier
            .fillMaxWidth()) {
        TweetAccount()
        TweetMessage()
        TweetImage()
    }
}

@Composable
fun TweetAccount() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
        Row(){
            Text(
                text = "Jorge",
                modifier = Modifier.padding(start = 16.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.White
            )
            Text(
                text = "@Jorgila",
                modifier = Modifier.padding(horizontal = 4.dp),
                color = Color.LightGray,
                fontSize = 12.sp
            )
            Text(
                text = "4h",
                modifier = Modifier.padding(horizontal = 4.dp),
                color = Color.LightGray,
                fontSize = 12.sp
            )
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            Image(
                painter = painterResource(id = R.drawable.ic_dots),
                contentDescription = "options",
            )
        }
    }
}

@Composable
fun TweetMessage() {
    Text(
        text = "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit",
        modifier = Modifier.padding(start = 16.dp, top = 4.dp),
        fontSize = 14.sp,
        color = Color.White
    )
}

@Composable
fun TweetImage() {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "Image",
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .clip(RoundedCornerShape(10)),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun TweetFooter() {
    Row (Modifier.fillMaxWidth()){
        Row(Modifier.weight(1f), horizontalArrangement = Arrangement.Center){
            var comments by rememberSaveable {
                mutableStateOf(false)
            }
            Icon(
                painter =
                    if (comments) {
                        painterResource(id = R.drawable.ic_chat_filled)
                    } else {
                        painterResource(id = R.drawable.ic_chat)
                    },
                contentDescription = "Comments",
                modifier = Modifier.clickable { comments = !comments },
                tint = Color.White)

            if(comments){
                Text(text="2",
                    color = Color.White)
            } else {
                Text(text="1",
                    color = Color.White)
            }

        }
        Row(Modifier.weight(1f), horizontalArrangement = Arrangement.Center){
            var retweet by rememberSaveable {
                mutableStateOf(false)
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_rt),
                contentDescription = "retweet",
                modifier = Modifier.clickable { retweet = !retweet },
                tint = if(retweet){ Color.Blue } else { Color.White }
            )
            if(retweet){
                Text(text="2",
                    color = Color.White)
            } else {
                Text(text="1",
                    color = Color.White)
            }
        }
        Row(Modifier.weight(1f), horizontalArrangement = Arrangement.Center){
            var like by rememberSaveable {
                mutableStateOf(false)
            }
            Icon(
                painter =
                    if(like){
                        painterResource(id = R.drawable.ic_like_filled)
                    } else {
                        painterResource(id = R.drawable.ic_like)
                    },
                contentDescription = "like",
                modifier = Modifier.clickable { like = !like },
                tint = if(like){ Color.Red } else { Color.White }
            )
            if(like){
                Text(text="2",
                    color = Color.White)
            } else {
                Text(text="1",
                    color = Color.White)
            }
        }

    }
}

@Composable
fun MyDivider(){
    Column {
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
        )
    }
}
