package com.dflorencia.myapplication

import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MainMenu(
    modifier: Modifier = Modifier,
    scanner: () -> Unit = {}
){
    val context = LocalContext.current;

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
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
    ){
        val arcColor = Color(0xFF60483a)

        val configuration = LocalConfiguration.current
        val screenHeight = configuration.screenHeightDp.dp
        val screenWidth = configuration.screenWidthDp.dp

        val imagen = ImageBitmap.imageResource(R.drawable.logo)

        Canvas(
            modifier = Modifier,
            onDraw = {
                drawImage(
                    image = imagen,
                    topLeft = Offset(x = -50F, y = -screenHeight.value/4F)
                )
                drawArc(
                    topLeft = Offset(-screenHeight.value/2F,-screenHeight.value/2F),
                    color = arcColor,
                    startAngle = 270F,
                    sweepAngle = 180F,
                    useCenter = false,
                    size = Size(screenHeight.value,screenHeight.value),
                    style = Stroke(width = 10f)
                )
            }
        )

        TextButton(
            onClick = {
                Toast.makeText(context,"AYUNO INTERMITENTE PRESIONADO",Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.offset(x = screenWidth/2 - screenWidth/6, y= -screenWidth/2)
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null
            )
            Text(text = "AYUNO INTERMITENTE", color = Color.Black)
        }

        TextButton(
            onClick = {
                Toast.makeText(context,"CONTADOR PRESIONADO",Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.offset(x = screenWidth/2 - screenWidth/10, y= -screenWidth/2)
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null
            )
            Text(text = "CONTADOR", color = Color.Black)
        }

        TextButton(
            onClick = {
                scanner.invoke()
            },
            modifier = Modifier.offset(x = screenWidth/2 - screenWidth/20, y= -screenWidth/2)
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null
            )
            Text(text = "SCANNER", color = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainMenuPreview() {
    MainMenu()
}