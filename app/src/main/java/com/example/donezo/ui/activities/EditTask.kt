package com.example.donezo.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.donezo.setStatusBarColor
import com.example.donezo.ui.theme.Black_BG
import com.example.donezo.ui.theme.DonezoTheme

class EditTaskActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DonezoTheme {
                setStatusBarColor(color = Color.Black, darkIcons = false)
                CreateTaskScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTaskScreen() {
    var selectedColor by remember { mutableStateOf(Color(0xFFFFD1A8)) }
    var title by remember { mutableStateOf(TextFieldValue("")) }
    var note by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        // Top bar with "Create Task", Star and Check icons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Create Task",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge
            )
            Row {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Favorite",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Save",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Note Color Options
        Text(text = "Note", color = Color.White, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            val colors = listOf(
                Color(0xFFFFD1A8), // Peach
                Color(0xFFFFE6A8), // Light Yellow
                Color(0xFFD1C4FF), // Purple
                Color(0xFFB2F5EA), // Light Blue
                Color(0xFFFFC1E3)  // Pink
            )

            colors.forEach { color ->
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .padding(8.dp)
                        .clip(CircleShape)
                        .background(color)
                        .clickable {
                            selectedColor = color
                        },
                    contentAlignment = Alignment.Center
                ) {
                    if (color == selectedColor) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Selected Color",
                            tint = Color.Black,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Divider()

        // Date Input Field (just for display, not functional)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent, RoundedCornerShape(8.dp))
                .padding(vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.DateRange, // Replace with a calendar icon
                contentDescription = "Calendar",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Sept 10, 2024",
                color = Color.White,
                fontSize = 16.sp
            )
        }

        Divider()

        // Title and Note input fields
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text(text = "Enter Title Here", color = Color.Gray) },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedTextColor = Color.White,
                cursorColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        Divider()

        TextField(
            value = note,
            onValueChange = { note = it },
            label = { Text(text = "Enter Note", color = Color.Gray) },
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp), // Adjust height for multiline display
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedTextColor = Color.White,
                cursorColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            maxLines = 5, // Set this to control the maximum number of lines
            singleLine = false // Ensures that the TextField allows multiline input
        )

    }
}

@Preview(showBackground = true)
@Composable
fun CreateTaskScreenPreview() {
    CreateTaskScreen()
}
