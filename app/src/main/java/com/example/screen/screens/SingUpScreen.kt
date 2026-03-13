package com.example.screen.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SingUpScreen(navController: NavController) {

    var nombre by remember { mutableStateOf("") }
    var mail by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    // Validaciones
    val isNameValid = nombre.all { it.isLetter() || it.isWhitespace() } && nombre.isNotBlank()
    val isEmailValid = android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches()
    val isPhoneValid = telefono.length == 10 && telefono.all { it.isDigit() }
    val isPasswordValid = password.isNotBlank()
    val arePasswordsEqual = password == confirmPassword && isPasswordValid

    val isFormValid = isNameValid && isEmailValid && isPhoneValid && arePasswordsEqual

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Título Principal
        Text(
            text = "Registro",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Tarjeta blanca
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                // Campo Nombre
                Text(text = "Nombre", fontWeight = FontWeight.Medium, fontSize = 14.sp)
                TextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    placeholder = { Text("Solo letras") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    isError = !isNameValid && nombre.isNotEmpty(),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFF3F4F6),
                        unfocusedContainerColor = Color(0xFFF3F4F6),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Campo Correo
                Text(text = "Email", fontWeight = FontWeight.Medium, fontSize = 14.sp)
                TextField(
                    value = mail,
                    onValueChange = { mail = it },
                    placeholder = { Text("ejemplo@correo.com") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    isError = !isEmailValid && mail.isNotEmpty(),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFF3F4F6),
                        unfocusedContainerColor = Color(0xFFF3F4F6),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Campo Teléfono
                Text(text = "Teléfono", fontWeight = FontWeight.Medium, fontSize = 14.sp)
                TextField(
                    value = telefono,
                    onValueChange = { if (it.length <= 10) telefono = it },
                    placeholder = { Text("10 dígitos") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    isError = !isPhoneValid && telefono.isNotEmpty(),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFF3F4F6),
                        unfocusedContainerColor = Color(0xFFF3F4F6),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Campo Contraseña
                Text(text = "Password", fontWeight = FontWeight.Medium, fontSize = 14.sp)
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = { Text("Mínimo 1 carácter") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFF3F4F6),
                        unfocusedContainerColor = Color(0xFFF3F4F6),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Campo Confirmar Contraseña
                Text(text = "Confirm Password", fontWeight = FontWeight.Medium, fontSize = 14.sp)
                TextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    placeholder = { Text("Repite contraseña") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    isError = !arePasswordsEqual && confirmPassword.isNotEmpty(),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFF3F4F6),
                        unfocusedContainerColor = Color(0xFFF3F4F6),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Botón Registro
                Button(
                    onClick = { navController.navigate("login") },
                    enabled = isFormValid, // Desactivado si el formulario no es válido
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF0D47A1),
                        disabledContainerColor = Color.Gray
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Registro", color = Color.White, fontSize = 16.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Texto inferior
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Ya tienes una cuenta? ", fontSize = 14.sp)
            Text(
                text = "Login",
                color = Color(0xFF0D47A1),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier.clickable { navController.navigate("login") }
            )
        }
    }
}
