package com.example.screen.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.screen.R

@Composable
fun WelcomeScreen(navController: NavController) {
    val primaryColor = Color(0xFF5558B6)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp, vertical = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.mario),
            contentDescription = "Main illustration",
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(bottom = 24.dp)
        )

        Text(
            text = "Hello",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Welcome To Little Drop, where\nyou manage your daily tasks",
            fontSize = 14.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Botón Login
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(primaryColor, shape = RoundedCornerShape(25.dp))
                .clickable { navController.navigate("login") },
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Login", color = Color.White, fontWeight = FontWeight.SemiBold)
        }

        // Botón Sign Up
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .height(50.dp)
                .border(width = 1.dp, color = primaryColor, shape = RoundedCornerShape(25.dp))
                .background(Color.White, shape = RoundedCornerShape(25.dp))
                .clickable { navController.navigate("signup") },
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Sign Up", color = primaryColor, fontWeight = FontWeight.SemiBold)
        }

        Text(
            text = "Sign up using",
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier.padding(top = 32.dp, bottom = 16.dp)
        )

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(modifier = Modifier.size(40.dp).background(Color(0xFF3B5998), CircleShape), contentAlignment = Alignment.Center) {
                Text("f", color = Color.White, fontWeight = FontWeight.Bold)
            }

            Box(modifier = Modifier.padding(start = 16.dp).size(40.dp).background(Color(0xFFDB4437), CircleShape), contentAlignment = Alignment.Center) {
                Text("G+", color = Color.White, fontWeight = FontWeight.Bold)
            }
            Box(modifier = Modifier.padding(start = 16.dp).size(40.dp).background(Color(0xFF0077B5), CircleShape), contentAlignment = Alignment.Center) {
                Text("in", color = Color.White, fontWeight = FontWeight.Bold)
            }
        }
    }
}
