package com.demo_app

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            val context= LocalContext.current

            var list=mutableListOf("Test1","Test2","Test3","Test4","Test5")


            var counterValue by remember { mutableStateOf(0) }

            Column(modifier = Modifier.padding(10.dp)){
                Text(text = "Hello World", fontSize = 30.sp, color = Color.Black, fontWeight = FontWeight.Bold, modifier = Modifier.padding(10.dp).align(alignment = Alignment.CenterHorizontally))

                Button(
                    modifier = Modifier.padding(10.dp).fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Green
                    ),
                    onClick = {

//hello
Toast.makeText(context,"Good Evening Sir", Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = "Save", fontSize = 15.sp, color = Color.White, fontWeight = FontWeight.Bold)
                }
                Button(
                    modifier = Modifier.padding(10.dp).fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow
                    ),
                    onClick = {
                    Toast.makeText(context,"Submit all  List data", Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = "Submit", fontSize = 15.sp, color = Color.White, fontWeight = FontWeight.Bold)
                }


                Text(text = "$counterValue", fontSize = 30.sp, color = Color.Black, fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 10.dp).align(alignment = Alignment.CenterHorizontally))

                Row(

                    modifier = Modifier.padding(top = 10.dp)
                ) {
                Button(
                    enabled = counterValue<10,
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.padding(10.dp).weight(0.5f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue
                    ),
                    onClick = {
                        counterValue++
                }) {
                    Text(text = "+", fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.Bold)
                }

                    Button(
                        enabled = counterValue>0,

                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.padding(10.dp).weight(0.5f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Blue
                        ),
                        onClick = {
                            counterValue--
                        }) {
                        Text(text = "-", fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.Bold)
                    }
                }

                HorizontalPager(
                    modifier = Modifier.padding(10.dp)
                        .background(color = Color.LightGray, shape = RoundedCornerShape(10.dp)).fillMaxWidth().height(200.dp),
                    state = rememberPagerState(
                        initialPage = 0,
                        pageCount = {list.size}
                    )
                ) {index->
                    Column(modifier = Modifier.padding(10.dp).fillMaxSize().background(color = Color.Green)) {
                        Text(text = list[index],

                            fontSize = 30.sp, color = Color.Blue, fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(10.dp).align(alignment = Alignment.CenterHorizontally))

                    }
                }

                Row(modifier = Modifier.padding(10.dp).align(alignment = Alignment.CenterHorizontally)) {
                    list.map {
                        Box(
                            modifier = Modifier.padding(5.dp).size(20.dp).clip(CircleShape)
                                .background(color = Color.LightGray)
                        )
                    }
                }

            }
    }
}


}