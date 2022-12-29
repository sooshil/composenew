package com.example.compose

import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheet(
    modifier: Modifier = Modifier
) {

    val sheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Collapsed,
//        animationSpec = tween(
//            durationMillis = 800
//        )
    )
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )
    val scope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    //.height(300.dp) /** The height of the bottomsheet. */
                ,
                contentAlignment = Alignment.Center
            ) {
                LazyColumn(modifier.fillMaxWidth()) {
                    items(20) {
                        Text(
                            text = "The item is $it",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        },
        sheetBackgroundColor = Color.Green,
        sheetElevation = 10.dp,
        sheetPeekHeight = 0.dp,
        sheetShape = RoundedCornerShape(
            topStart = 20.dp,
            topEnd = 20.dp,
        )
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Button(onClick = {
                scope.launch {
                    if (sheetState.isCollapsed) {
                        sheetState.expand()
                    } else sheetState.collapse()
                }
            }) {
                Text(text = "Toggle BottomSheet" /**${sheetState.progress.fraction}*/)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomSheetPreview() {
    BottomSheet()
}