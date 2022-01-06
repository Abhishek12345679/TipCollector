package com.abhisheksah.tipcollector

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abhisheksah.tipcollector.ui.theme.TipCollectorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContent set the main composable (the one immediately inside it) to the activity
        setContent {
            TipCollectorTheme {
                MyApp{
                    Header()
                    Column() {
                        AmountDisplay()
                    }
                }
            }
        }
    }
}

//@Preview
@Composable
fun AmountDisplay(totalPerPerson: Double = 0.0){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .clip(RoundedCornerShape(12.dp)),
        color = Color(0xFFE5D2F5)
        ,
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Total Per Person", style = MaterialTheme.typography.h5)
            Text(text = "₹$totalPerPerson",style = MaterialTheme.typography.h4, fontWeight = FontWeight.ExtraBold)
        }
    }
}

//@Preview
@Composable
fun Header(){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        color = MaterialTheme.colors.primary,

    ) {
        Column(
            modifier = Modifier
                .padding(start= 10.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(text = "Tip Collector")
        }
    }
}

@Preview
@Composable
fun MainContent(){
    Surface(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
        ,
        border= BorderStroke(1.dp,Color.LightGray) ,
        shape = RoundedCornerShape(CornerSize(8.dp))
    ) {
        Text(text = "hello world")
    }
}


@Composable
fun MyApp(content: @Composable () -> Unit){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
        ,
    ) {
       content()
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TipCollectorTheme {
        MyApp{
            Column() {
                Header()
                Column(
                    modifier = Modifier
                    .padding(20.dp)
                ) {
                    AmountDisplay()
                    Spacer(modifier = Modifier.height(20.dp))
                    MainContent()
                }
            }
        }
    }
}