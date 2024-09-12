package com.example.donezo.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.donezo.ui.theme.Black
import com.example.donezo.ui.theme.Grey
import com.example.donezo.ui.theme.Light_Blue
import com.example.donezo.ui.theme.Light_Grey
import com.example.donezo.ui.theme.Light_Purple
import com.example.donezo.ui.theme.Purple
import com.example.donezo.ui.theme.Typography


@Composable
fun cardView() {
    Card(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp), // Add padding around the Card
        shape = Shapes().medium,
        border = BorderStroke(1.dp, Light_Grey)// Rounded corners // Optional: Adds shadow/elevation
    ) {
        Row(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(16.dp), // Add padding inside the Card
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically // Align items vertically center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(shape = Shapes().extraLarge, color = Light_Grey) {
                    Icon(
                        modifier = Modifier.padding(6.dp), imageVector = Icons.Default.Person,
                        tint = Black,
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Text(text = "Work", style = Typography.titleMedium)
            }
        }
    }
}

@Preview
@Composable
fun card_preview() {
    cardView()
}