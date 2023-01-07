package com.example.compose.animatedcircleandsearch

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PulsatingCircleAnimation(
    modifier: Modifier = Modifier
) {
    val circleColor = Color(0xFFffb59c)
    val frontCircle = circleColor.copy(0.75f)
    val midCircle = circleColor.copy(0.50f)
    val backCircle = circleColor.copy(0.25f)
    
    DrawCircleOnCanvas(
        scale = scaleInfiniteTransition(targetValue = 2f, durationMillis = 600),
        color = backCircle,
        radiusRatio = 4f
    )
    DrawCircleOnCanvas(
        scale = scaleInfiniteTransition(targetValue = 2.5f, durationMillis = 800),
        color = midCircle,
        radiusRatio = 6f
    )
    DrawCircleOnCanvas(
        scale = scaleInfiniteTransition(targetValue = 3f, durationMillis = 1000),
        color = frontCircle,
        radiusRatio = 12f
    )
}

@Composable
fun scaleInfiniteTransition(
    initialValue: Float = 0f,
    targetValue: Float,
    durationMillis: Int,
): Float {
    val infiniteTransition = rememberInfiniteTransition()
    val scale: Float by infiniteTransition.animateFloat(
        initialValue = initialValue,
        targetValue = targetValue,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = durationMillis,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )
    return scale
}

@Composable
fun DrawCircleOnCanvas(
    scale: Float,
    color: Color,
    radiusRatio: Float
) {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
    ) {
        drawCircle(
            color = color,
            center = Offset(
                x = size.width / 2,
                y = size.height / 2
            ),
            radius = size.minDimension / radiusRatio
        )
    }
}

@Preview
@Composable
fun PulsatingCircleAnimationPreview() {
    PulsatingCircleAnimation()
}