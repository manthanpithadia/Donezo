package com.example.donezo.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.donezo.R
import com.example.donezo.ui.components.cardView
import com.example.donezo.ui.theme.Black
import com.example.donezo.ui.theme.DonezoTheme
import com.example.donezo.ui.theme.Grey
import com.example.donezo.ui.theme.InterFontFamily
import com.example.donezo.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DonezoTheme {
                Title()
            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Title() {
    Scaffold(modifier = Modifier.background(Color.White), topBar = {
        TopAppBar(title = { TopBar() })
    }, bottomBar = {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 18.dp)
        ) {
            Button(
                onClick = { /*TODO*/ }, shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
            ) {
                Text(
                    text = "CREATE TASK",
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = InterFontFamily,
                    fontSize = 18.sp,
                    color = Color.White
                )
            }
        }
    }, content = { innerPadding ->
        //TODO: Create a LazyColumn here
        LazyColumn(modifier = Modifier
            .padding(innerPadding)
            .padding(horizontal = 16.dp, vertical = 16.dp))
        {
            items(10){
                cardView()
            }
        }
    })
}

@Composable
fun TopBar() {
    Column() {
        Text(
            text = stringResource(id = R.string.app_name),
            style = Typography.headlineLarge,
            color = Black
        )
        Text(
            text = stringResource(id = R.string.tag_line),
            style = Typography.titleMedium,
            color = Grey
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    DonezoTheme {
        Title()
    }
}

