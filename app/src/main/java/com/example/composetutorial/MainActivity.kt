package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(Message("Android", "JetpackCompose"));
        }
    }
}
data class Message(val author: String, val body: String)
@Composable
fun MessageCard(msg: Message){
    //add padding around our messages
    Row(modifier = Modifier.padding(all=8.dp)) {
        Image(painter = painterResource(R.drawable.img),
            contentDescription = "Image Profile",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )

        //Add horizontal image between the image and the column
        Spacer(modifier = Modifier.width(8.dp))
        Column() {
            Text(text = msg.author)
            //add vertical space between Author and Message
            Spacer(modifier = Modifier.height(4.dp))
            Text(msg.body)
        }



    }
    Text(text = msg.author)
    Text(msg.body)
}
@Preview
@Composable
fun PreviewMessageCard(){
    MessageCard(
        msg = Message("collegue", "Heyyy, Take a Look at Jetpack Compose")
    )
}