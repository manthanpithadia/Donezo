package com.example.donezo.ui.activities

import android.os.Build
import android.os.Bundle
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.sp

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
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
import com.example.donezo.ui.theme.Black
import com.example.donezo.ui.theme.Black_BG
import com.example.donezo.ui.theme.DonezoTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle

class EditTaskActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
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

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTaskScreen() {
    var selectedColor by remember { mutableStateOf(Color(0xFFFFD1A8)) }
    var title by remember { mutableStateOf(TextFieldValue("")) }
    var note by remember { mutableStateOf(TextFieldValue("")) }

    // Date Picker Logic
    // State to hold the selected date
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }
    val datePickerState =
        rememberDatePickerState(initialSelectedDateMillis = selectedDate.toEpochDay() * 24 * 60 * 60 * 1000)
    var showDatePicker by remember { mutableStateOf(false) }

    // Formatter to display the date
    val dateFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy")
    // Dark theme colors
    val darkColors = darkColorScheme(
        primary = Color(0xFFBB86FC),
        onPrimary = Color.Black,
        secondary = Color(0xFFFFC1E3),
        onSecondary = Color.Black,
        background = Color(0xFF121212),
        surface = Color(0xFF121212),
        onSurface = Color.White
    )

    // Date Picker Dialog
    if (showDatePicker) {
        MaterialTheme(colorScheme = darkColors) { // Applying dark theme
            DatePickerDialog(
                onDismissRequest = { showDatePicker = false },
                confirmButton = {
                    TextButton(onClick = {
                        selectedDate = LocalDate.ofEpochDay(datePickerState.selectedDateMillis!! / (24 * 60 * 60 * 1000))
                        showDatePicker = false
                    }) {
                        Text("OK", color = Color.White)
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDatePicker = false }) {
                        Text("Cancel", color = Color.White)
                    }
                }
            ) {
                DatePicker(
                    state = datePickerState,
                    colors = DatePickerDefaults.colors()
                )
            }
        }
        }

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
                    modifier = Modifier.size(24.dp).clickable {
                        // on Star Click
                    }
                )
                Spacer(modifier = Modifier.width(16.dp))
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Save",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp).clickable {
                        // on Save Click
                    }
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
                        .size(52.dp)
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
                            modifier = Modifier.size(26.dp)
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
                .padding(vertical = 12.dp)
                .clickable {
                    //TODO: Implement date picker
                    showDatePicker = true
                },
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

        var noteText by remember { mutableStateOf(TextFieldValue()) }

        TextField(
            value = noteText,
            onValueChange = { noteText = it },
            label = { Text(text = "Enter Note Here", color = Color.Gray) },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedTextColor = Color.White,
                cursorColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            textStyle = androidx.compose.ui.text.TextStyle(
                fontSize = 20.sp,
                color = Color.White
            )
        )



    }
}



@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun CreateTaskScreenPreview() {
    CreateTaskScreen()

}
