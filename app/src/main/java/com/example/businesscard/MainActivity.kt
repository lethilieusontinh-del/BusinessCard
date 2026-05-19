package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                BusinessCard()

                }
            }
        }
    }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Composable
fun CenterSection(name: String, title: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

       Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier.width(100.dp).background(Color(0xFF073042))
        )
        Text(
            text = name,
            fontSize = 40.sp,
            fontWeight = FontWeight.Light
        )
        Text(
            text = title,
            color = Color(0xFF3ddc84),
            fontWeight = FontWeight.Bold
        )
    }
}
@Composable
fun ContactLine(icon: ImageVector, text: String) {
    Row(modifier = Modifier.padding(8.dp)) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF3ddc84)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = text)
    }
}
@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD2E8D4)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Gọi phần trung tâm
        CenterSection(name = "Lee Sink", title = "Android Developer")

        Spacer(modifier = Modifier.height(100.dp)) // Tạo khoảng cách

        // Gọi phần liên hệ
        Column {
            ContactLine(icon = Icons.Default.Phone, text = "+84 353215995")
            ContactLine(icon = Icons.Default.Share, text = "@AndroidDev")
            ContactLine(icon = Icons.Default.Email, text = "sinhpl.24ai@vku.udn.vn")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard() // Gọi cái này để nó vẽ danh thiếp ra màn hình xem trước
    }
}