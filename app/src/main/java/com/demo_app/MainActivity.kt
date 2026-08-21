package com.demo_app

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

            Column(modifier = Modifier.padding(10.dp)){
                Text(text = "Hello World", fontSize = 30.sp, color = Color.Black, fontWeight = FontWeight.Bold, modifier = Modifier.padding(10.dp).align(alignment = Alignment.CenterHorizontally))

                Button(
                    modifier = Modifier.padding(10.dp).fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue
                    ),
                    onClick = {
Toast.makeText(context,"Hello Sir", Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = "Save", fontSize = 15.sp, color = Color.White, fontWeight = FontWeight.Bold)
                }
            }
    }
}


}