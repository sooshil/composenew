package com.example.compose

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Sun(
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(
        modifier = modifier
            .aspectRatio(1f)
            .fillMaxSize()
            .background(Color(0xFFD1D1D1))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        val width = maxWidth
        val radius = width / 2
        Log.d("TAG", "Sun: width is $width and radius is $radius")
        Canvas(
            modifier = modifier,
        ) {
            /** Change these values to see the resulting preview. */
            var angle = 0f
            val deltaAngle = -5f
            val distance = radius.toPx() * 0.96f
//
//            drawCircle(
//                color = Color.Red,
//                radius = radius.toPx(),
//                style = Stroke(
//                    width = 4.dp.toPx()
//                )
//            )

            drawCircle(
                color = Color.Red,
                radius = radius.toPx() * 0.02f,
                style = Fill
            )
//
//            drawLine(
//                color = Color.Red,
//                start = Offset(size.center.x, size.center.y),
//                end = Offset(
//                    x = (size.center.x + (radius.toPx() * cos(radianAngle(angle))).toFloat()),
//                    y = (size.center.y + (radius.toPx() * sin(radianAngle(angle))).toFloat())
//                ),
//                strokeWidth = 4.dp.toPx()
//            )

            (1..36).forEachIndexed { index, value ->
                if(index % 2 != 0) {
                    drawLine(
                        color = Color.Red,
                        start = Offset(size.center.x, size.center.y),
                        end = Offset(
                            x = ((size.center.x + (distance * cos(radianAngle(angle - deltaAngle))) / cos(
                                radianAngle(deltaAngle)
                            )).toFloat()),
                            y = (size.center.y + (distance * sin(radianAngle(angle - deltaAngle))) / cos(
                                radianAngle(deltaAngle)
                            )).toFloat()
                        ),
                        strokeWidth = 4.dp.toPx()
                    )
                }

                drawLine(
                    color = Color.Red,
                    start = Offset(size.center.x, size.center.y),
                    end = Offset(
                        x = ((size.center.x + (distance * cos(radianAngle(angle + deltaAngle))) / cos(
                            radianAngle(-deltaAngle)
                        )).toFloat()),
                        y = (size.center.y + (distance * sin(radianAngle(angle + deltaAngle))) / cos(
                            radianAngle(-deltaAngle)
                        )).toFloat()
                    ),
                    strokeWidth = 4.dp.toPx()
                )

                drawLine(
                    color = Color.Red,
                    start = Offset(
                        x = ((size.center.x + (distance * cos(radianAngle(angle + deltaAngle))) / cos(
                            radianAngle(-deltaAngle)
                        )).toFloat()),
                        y = (size.center.y + (distance * sin(radianAngle(angle + deltaAngle))) / cos(
                            radianAngle(-deltaAngle)
                        )).toFloat()
                    ),
                    end = Offset(
                        x = (size.center.x + (radius.toPx() * cos(radianAngle(angle))).toFloat()),
                        y = (size.center.y + (radius.toPx() * sin(radianAngle(angle))).toFloat())
                    ),
                    strokeWidth = 4.dp.toPx()
                )

                drawLine(
                    color = Color.Red,
                    start = Offset(
                        x = ((size.center.x + (distance * cos(radianAngle(angle - deltaAngle))) / cos(
                            radianAngle(deltaAngle)
                        )).toFloat()),
                        y = (size.center.y + (distance * sin(radianAngle(angle - deltaAngle))) / cos(
                            radianAngle(deltaAngle)
                        )).toFloat()
                    ),
                    end = Offset(
                        x = (size.center.x + (radius.toPx() * cos(radianAngle(angle))).toFloat()),
                        y = (size.center.y + (radius.toPx() * sin(radianAngle(angle))).toFloat())
                    ),
                    strokeWidth = 4.dp.toPx()
                )
                angle += 10
            }
        }
    }
}

fun radianAngle(angle: Float) = angle * PI / 180

@Preview(showBackground = true)
@Composable
fun SunPreview() {
    Sun()
}