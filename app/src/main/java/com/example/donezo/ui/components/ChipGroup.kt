@file:Suppress("IMPLICIT_CAST_TO_ANY")

package com.example.donezo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.donezo.ui.theme.Black_g1
import com.example.donezo.ui.theme.Black_g2
import com.example.donezo.ui.theme.Black_g3
import com.example.donezo.ui.theme.Black_g4
import com.example.donezo.ui.theme.Stroke_g1
import com.example.donezo.ui.theme.Stroke_g2
import com.example.donezo.ui.theme.Stroke_g3
import com.example.donezo.ui.theme.chip_unSelected

@Composable
fun ChipGroupCompose() {

    val chips = listOf<String>(
        "All",
        "Favourite",
        "Due Today",
        "Task Done"
    )

    var selected by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        chips.forEach { it ->
            Chip(title = it,
                selected = selected,
                onSelected = { selected = it })
        }
    }
}

@Composable
fun Chip(
    title: String,
    selected: String,
    onSelected: (String) -> Unit
) {
    val isSelected = selected == title

    val background = if (isSelected) {
        Brush.linearGradient(colors = listOf(Black_g1, Black_g2, Black_g3, Black_g4),
            start = Offset(0f,0f),
            end = Offset(120f,200f)
        )
    } else {
        Brush.linearGradient(colors = listOf(chip_unSelected, chip_unSelected))
    }
    val stroke = if (isSelected) {
        Brush.linearGradient(colors = listOf(Stroke_g1, Stroke_g2, Stroke_g3))
    } else {
        Brush.linearGradient(colors = listOf(chip_unSelected, chip_unSelected))
    }

    Box(
        modifier = Modifier
            .wrapContentSize()
            .background(brush = stroke, shape = CircleShape)
            .padding(2.dp)
    ) {

        Box(
            modifier = Modifier
                .height(32.dp)
                .clip(CircleShape)
                .background(brush = background)
                .clickable(onClick = {
                    onSelected(title)
                }),
            ) {
            Row(
                modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = title,
                    color = androidx.compose.ui.graphics.Color.White,
                    fontSize = 16.sp
                )
            }
        }
    }
    Spacer(modifier = Modifier.padding(5.dp))
}
