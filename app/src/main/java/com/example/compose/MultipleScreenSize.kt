package com.example.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MultipleScreenSize(
    modifier: Modifier = Modifier
) {
    val windowInfo = RememberWindowInfo()
    if(windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) {
        LazyColumn(
            modifier = modifier.fillMaxSize()
        ) {
            items(10) {
                Text(
                    text = "The item is $it",
                    fontSize = 20.sp,
                    modifier = modifier
                        .background(Color(0xFFA695EE))
                        .padding(16.dp)
                        .fillMaxWidth()
                )
            }

            items(15) {
                Text(
                    text = "The item is $it",
                    fontSize = 20.sp,
                    modifier = modifier
                        .background(Color(0xFFE7B2B2))
                        .padding(16.dp)
                        .fillMaxWidth()
                )
            }
        }
    } else {
        Row(modifier = modifier.fillMaxWidth()) {
            LazyColumn(
                modifier = modifier.weight(1f)
            ) {
                items(10) {
                    Text(
                        text = "The item is $it",
                        fontSize = 20.sp,
                        modifier = modifier
                            .background(Color(0xFFA695EE))
                            .padding(16.dp)
                            .fillMaxWidth()
                    )
                }
            }
            LazyColumn(
                modifier = modifier.weight(1f)
            ) {
                items(15) {
                    Text(
                        text = "The item is $it",
                        fontSize = 20.sp,
                        modifier = modifier
                            .background(Color(0xFFE7B2B2))
                            .padding(16.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }
    }

}

@Preview
@Composable
fun MultipleScreenPreview() {
    MultipleScreenSize()
}


@Composable
fun RememberWindowInfo(): WindowInfo {
    val configuration = LocalConfiguration.current
    return WindowInfo(
        screenWidthInfo = when {
            configuration.screenWidthDp < 600 -> WindowInfo.WindowType.Compact
            configuration.screenWidthDp < 840 -> WindowInfo.WindowType.Medium
            else -> WindowInfo.WindowType.Expanded
        },
        screenHeightInfo = when {
            configuration.screenHeightDp < 480 -> WindowInfo.WindowType.Compact
            configuration.screenHeightDp < 900 -> WindowInfo.WindowType.Medium
            else -> WindowInfo.WindowType.Expanded
        },
        screenWidth = configuration.screenWidthDp.dp,
        screenHeight = configuration.screenHeightDp.dp
    )
}

data class WindowInfo(
    val screenWidthInfo: WindowType,
    val screenHeightInfo: WindowType,
    val screenWidth: Dp,
    val screenHeight: Dp
) {
    sealed class WindowType {
        object Compact: WindowType()
        object Medium: WindowType()
        object Expanded: WindowType()
    }
}