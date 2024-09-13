package com.example.donezo.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.donezo.R
import com.example.donezo.ui.theme.Black
import com.example.donezo.ui.theme.Light_Grey
import com.example.donezo.ui.theme.Typography

@Composable
fun cardView() {
    Surface(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        color = Color(0xFFFFD1A8)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Circle indicator on the left
            Row {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Black, shape = CircleShape)
                )

                Spacer(modifier = Modifier.width(16.dp))

                // Column for the task title, description, and date
                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "Taking My Sister To School",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Black
                    )
                    Text(
                        text = "Description",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Surface(
                        shape = RoundedCornerShape(18.dp),
                        border = BorderStroke(1.dp, Color.Black),
                        color = Color.White,
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Text(
                            text = "Thu, Sep 12, 8 PM",
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Black,
                            fontSize = 12.sp
                        )
                    }
                }

                // Spacer to push the heart icon to the right
                Spacer(modifier = Modifier.width(16.dp))

                // Heart icon on the right
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(Color.Black),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_heart_border),
                        modifier = Modifier.size(18.dp),
                        contentDescription = null,
                        tint = Color.Gray
                    )
                    /*Text(
                        text = "❤",
                        color = Color(0xFFFF4081),
                        fontSize = 16.sp
                    )*/
                }
            }
        }
    }
}


@Preview
@Composable
fun card_preview() {
    cardView()
}