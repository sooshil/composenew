package com.example.compose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NeoMorphism(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BoxWithConstraints(
            modifier = modifier
                .padding(16.dp)
                .aspectRatio(1f)
                .padding(16.dp)
                .border(
                    color = Color.LightGray,
                    width = 2.dp,
                    shape = CircleShape
                )
                .shadow(
                    elevation = 10.dp,
                    shape = CircleShape
                )
            ,
            contentAlignment = Alignment.Center
        ) {
//            Canvas(
//                modifier = modifier
//                    .fillMaxSize()
//                    .padding(32.dp)
//                    .offset(
//                        x = 0.dp,
//                        y = (-20).dp
//                    )
//            ) {
//                drawCircle(
//                    color = Color.Red,
//                    radius = size.minDimension / 2f,
//                )
//                drawArc(
//                    color = Color.Red,
//                    startAngle = 180f,
//                    sweepAngle = 360f,
//                    useCenter = true,
//                    style = Fill
//                )
//            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NeoMorphismPreview() {
    NeoMorphism()
}