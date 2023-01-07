package com.example.compose.animatedcircleandsearch

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SearchIconAnimation(
    modifier: Modifier = Modifier
) {

    val animateCircle by remember {
        mutableStateOf(Animatable(0f))
    }

    val animateLine by remember {
        mutableStateOf(Animatable(0.5f))
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        val strokeWidth = 26f
        AnimateShapeInfinitely(animatableShape = animateCircle)
        AnimateShapeInfinitely(animatableShape = animateLine)

        Canvas(modifier = modifier) {
            val arcSize = 180f
            drawArc(
                color = Color(0xFF1f2d2d),
                startAngle = 45f,
                sweepAngle = 360f * animateCircle.value,
                useCenter = false,
                size = Size(arcSize, arcSize),
                style = Stroke(
                    width = strokeWidth,
                    cap = StrokeCap.Round
                ),
                topLeft = Offset(
                    x = (size.width / 2) - (arcSize / 2),
                    y = (size.height / 2) - (arcSize / 2)
                )
            )

            drawLine(
                color = Color(0xFF1f2d2d),
                strokeWidth = strokeWidth,
                start = Offset(
                    x = 64f * animateLine.value,
                    y = 64f * animateLine.value
                ),
                end = Offset(
                    x = 150f * animateLine.value,
                    y = 150f * animateLine.value
                ),
                cap = StrokeCap.Round
            )
        }
    }
}

@Composable
fun AnimateShapeInfinitely(
    animatableShape: Animatable<Float, AnimationVector1D>
) {
    LaunchedEffect(key1 = animatableShape) {
        animatableShape.animateTo(
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 1000,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Restart
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchAnimationPreview() {
    SearchIconAnimation()
}