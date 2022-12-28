package com.example.compose

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonElevation
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MultiSelectList(
    modifier: Modifier = Modifier
) {
    var items by remember {
        mutableStateOf(
            (1..30).map {
                ListItem(
                    "Item $it",
                    false
                )
            }
        )
    }



    Column(
        modifier = modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = {
                val selectedItems = items.filter { it.isSelected }
                Log.d("TAG", "Selected items are: $selectedItems")
            }
        ) {
            Text(
                text = "Send selected items"
            )
        }
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
        ) {
            items(items.size) { index ->
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .clickable {
                            items = items.mapIndexed { j, item ->
                                if (index == j) {
                                    item.copy(isSelected = !item.isSelected)
                                } else item
                            }
                        }
                        .background(if (index % 2 == 0) Color(0xFFD0F0E0) else Color(0xFFD0E0F0))
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = items[index].title,
                        fontSize = 16.sp,
                        overflow = TextOverflow.Ellipsis
                    )
                    if (items[index].isSelected) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = null,
                            tint = Color.Green,
                            modifier = modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }
}

data class ListItem(
    val title: String,
    val isSelected: Boolean
)

@Preview(showBackground = true)
@Composable
fun MultiSelectPreview() {
    MultiSelectList()
}