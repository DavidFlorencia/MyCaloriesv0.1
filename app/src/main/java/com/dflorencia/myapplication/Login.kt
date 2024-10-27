package com.dflorencia.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dflorencia.myapplication.ui.theme.MyApplicationTheme

@Composable
fun Login(
    modifierExt: Modifier = Modifier,
    nextScreen: () -> Unit = {}
) {
    var switchEncendido by remember { mutableStateOf(true) }
    var email by remember { mutableStateOf("") }
    var usuario by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    val titulo = stringResource(
        if(switchEncendido){
            R.string.iniciar_sesion
        }else{
            R.string.registrarse
        }
    )

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifierExt
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(color = 0xFFd5bdaf),
                        Color(color = 0xFFedede9)
                    )
                )
            )
            .padding(5.dp)
            .fillMaxSize()
    ) {
        Text(
            text = titulo,
            fontSize = 30.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Switch(
            checked = switchEncendido,
            onCheckedChange = {
                switchEncendido = it
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        val imagen = painterResource(R.drawable.logo)
        Image(
            painter = imagen,
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = {
                Text(
                    stringResource(R.string.correo_electronico)
                )
            },
            modifier = Modifier.fillMaxWidth()
        )
        if(!switchEncendido){
            OutlinedTextField(
                value = usuario,
                onValueChange = {
                    usuario = it
                },
                label = {
                    Text(
                        stringResource(R.string.nombre_usuario)
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text(
                    stringResource(R.string.contrasena)
                )
            },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        if (!switchEncendido){
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = {
                    confirmPassword = it
                },
                label = {
                    Text(
                        stringResource(R.string.confirmar_contrasena)
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation()
            )
        }
        Button(
            onClick = {
                nextScreen.invoke()
            },
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFa07054))
        )
        {
            Text("Siguiente")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Login()
    }
}