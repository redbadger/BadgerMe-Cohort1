package com.example.badgermecohort1.navigation

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.badgermecohort1.R
import kotlinx.coroutines.delay
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun SplashScreenAnimate(navController: NavController) {
    val numberOfBars = 12
    val barValues = remember { mutableStateOf(1..numberOfBars) }
    val infiniteTransition = rememberInfiniteTransition()
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

        LaunchedEffect(key1 = true){
        //TODO: Need to change this so splash screen only lasts as long as it takes to load main screen
        delay(1000)
        navController.navigate("main_screen"){
            popUpTo("splash_screen"){
                inclusive=true
            }
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.rb_title),
            contentDescription = "rb title",
            modifier = Modifier.padding(Dp(50.0F))
        )
        Image(
            painter = painterResource(R.drawable.rb_logo),
            contentDescription = "Splash Image",
            Modifier.padding(Dp(10.0F))
        )
        Canvas(modifier = Modifier
            .height(100.dp)
            .width(100.dp)
            .padding(20.dp)) {
            val canvasWidth = size.width
            val canvasHeight = size.height
            val barWidth = 10F
            val barHeight = 30F
            val maxAlpha = 200
            val minAlpha = 20
            val alphaRange = (maxAlpha - minAlpha).toFloat()
            val baseColour = 100;
            val barSpread = 60F;
            val cornerRadius = 5;

            barValues.value.forEach {
                val degrees = (360F / numberOfBars) * (it - 1F)
                val degreesRad = Math.toRadians(degrees.toDouble()).toFloat()
                val alpha = (alphaRange * (scale + it / 12F)).mod(alphaRange).toInt() + minAlpha;

                withTransform({
                    translate(top = -barSpread * cos(degreesRad), left = barSpread * sin(degreesRad))
                    rotate(degrees = degrees)
                }) {
                    drawRoundRect(
                        color = Color(baseColour, baseColour, baseColour, alpha),
                        topLeft = Offset((canvasWidth - barWidth) / 2F, canvasHeight / 2F),
                        size = Size(barWidth, barHeight),
                        cornerRadius = CornerRadius(
                            x = cornerRadius.dp.toPx(),
                            y = cornerRadius.dp.toPx()
                        )
                    )
                }
            }
        }
        Text(text = "Loading")
    }
}