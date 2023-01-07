package com.example.compose

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CircleAnimation(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF857B7B))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        val circleSize by remember {
            mutableStateOf(Animatable(0.5f))
        }

        LaunchedEffect(key1 = circleSize) {
            circleSize.animateTo(
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = 1000,
                        easing = LinearEasing
                    ),
                    repeatMode = RepeatMode.Reverse
                )
            )
        }

        val circleSize2 by remember {
            mutableStateOf(Animatable(0.3f))
        }

        LaunchedEffect(key1 = circleSize2) {
            circleSize2.animateTo(
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = 1000,
                        easing = LinearEasing
                    ),
                    repeatMode = RepeatMode.Reverse
                )
            )
        }

        Canvas(modifier = modifier.fillMaxSize()) {
            val radius = size.minDimension / 4
            drawCircle(
                color = Color.Green.copy(0.5f),
                radius = radius * circleSize.value,
                center = Offset(
                    x = size.width / 2,
                    y = size.height / 2
                ),
                style = Fill
            )

            drawCircle(
                color = Color.Yellow.copy(0.3f),
                radius = radius * circleSize2.value,
                center = Offset(
                    x = size.width / 2,
                    y = size.height / 2
                ),
                style = Fill
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CircleAnimationPreview() {
    CircleAnimation()
}