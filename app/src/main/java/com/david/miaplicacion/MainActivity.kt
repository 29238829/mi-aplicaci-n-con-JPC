package com.david.miaplicacion

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.david.miaplicacion.ui.theme.MiaplicacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiaplicacionTheme {
                var isLoggedIn by remember { mutableStateOf(false) }
                val context = LocalContext.current

                if (isLoggedIn) {
                    BienvenidaScreen()
                } else {
                    LoginScreen(onLoginClick = {
                        isLoggedIn = true
                        Toast.makeText(context, "se ha iniciado sesion", Toast.LENGTH_SHORT).show()
                    })
                }
            }
        }
    }
}

@Composable
fun LoginScreen(onLoginClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Text(text = "Login", style = MaterialTheme.typography.headlineSmall)
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = onLoginClick) {
                Text("iniciar sesion")
            }
        }
    }
}

@Composable
fun BienvenidaScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo de la App",
                modifier = Modifier.size(150.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Text("Bienvenido a smartQr", style = MaterialTheme.typography.headlineSmall)
            }
        }
    }
}
