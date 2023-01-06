package com.example.compose

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene

@ExperimentalMotionApi
@Composable
fun AnimMotionLayout(
    modifier: Modifier = Modifier
) {

    /** video link
     * https://www.youtube.com/watch?v=1g3SPJxk4wc
     * */

    var progress by remember {
        mutableStateOf(0f)
    }
    Column(modifier = modifier.fillMaxWidth()) {
        ProfileHeader(progress = progress)
        Spacer(modifier = Modifier.height(16.dp))
        Slider(
            value = progress,
            onValueChange = { progress = it },
            modifier = modifier.padding(32.dp)
        )
    }
}


@ExperimentalMotionApi
@Composable
fun ProfileHeader(
    modifier: Modifier = Modifier,
    progress: Float
) {
    val context = LocalContext.current
    val motionScene = remember {
        context.resources.openRawResource(R.raw.motion_scene)
            .readBytes()
            .decodeToString()
    }
    MotionLayout(
        motionScene = MotionScene(content = motionScene),
        progress = progress,
        modifier = modifier.fillMaxWidth()
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(Color(0x55d5f5e5))
                .layoutId("box") /** This id is being used in the motion scene json */
        )
        Image(
            painter = painterResource(id = R.drawable.ic_person),
            contentDescription = null,
            modifier = modifier
                .clip(CircleShape)
                .border(
                    width = 3.dp,
                    color = Color.Green,
                    shape = CircleShape
                )
                .layoutId("profile_pic")
        )
        Text(
            text = "John Doe",
            color = Color.Blue,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier.layoutId("username")
        )
    }
}