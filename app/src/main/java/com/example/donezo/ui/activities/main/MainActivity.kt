package com.example.donezo.ui.activities.main

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.example.donezo.R
import com.example.donezo.data.NoteDao
import com.example.donezo.getNoteRepository
import com.example.donezo.repository.NoteRepository
import com.example.donezo.setStatusBarColor
import com.example.donezo.ui.activities.EditTask.EditTaskActivity
import com.example.donezo.ui.components.ChipGroupCompose
import com.example.donezo.ui.components.cardView
import com.example.donezo.ui.theme.Black_BG
import com.example.donezo.ui.theme.DonezoTheme
import com.example.donezo.ui.theme.Grey
import com.example.donezo.ui.theme.InterFontFamily
import com.example.donezo.ui.theme.Typography

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val repo = getNoteRepository()
        val viewModelFactory = MainActivityViewModelFactory(repo)
        viewModel = ViewModelProvider(this,viewModelFactory)[MainActivityViewModel::class.java]

        viewModel.navigateToEditTaskActivity.observe(this) { navigate ->
            if (navigate) {
                val context: Context = this
                val intent = Intent(context, EditTaskActivity::class.java)
                context.startActivity(intent)
            }
        }
        setContent {
            DonezoTheme {
                setStatusBarColor(color = Color.Black, darkIcons = false)
                Title(viewModel = viewModel)
            }
        }
    }

    private fun initViewModelObserver() {
        // Initializing View Model

    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Title(viewModel: MainActivityViewModel) {

    Scaffold(modifier = Modifier.fillMaxHeight(), topBar = {
        TopAppBar(title = {
            TopBar()
        }, colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Black_BG
        ),
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = null,
                        modifier = Modifier.size(48.dp)
                    )
                }
            })
    }, bottomBar = {
        BottomAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .systemBarsPadding(),
            containerColor = Black_BG, // Set the bottom app bar background color to black
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.wrapContentHeight()
            ) {
                Button(
                    onClick = { viewModel.onCreateTaskButtonClick() },
                    shape = RoundedCornerShape(32.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "CREATE TASK",
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = InterFontFamily,
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }, content = { innerPadding ->
        //TODO: Create a LazyColumn here
        Column(
            modifier = Modifier
                .fillMaxSize() // Make sure the content fills the entire screen
                .background(Black_BG) // Set background color to black
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp + innerPadding.calculateTopPadding(),
                    bottom = innerPadding.calculateBottomPadding() + (-40).dp
                )
        ) {
            ChipGroupCompose()
            Spacer(modifier = Modifier.padding(16.dp))
            Text(
                text = "Task List",
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp
            )
            LazyColumn(
                modifier = Modifier
                    .weight(2f)
                    .background(Black_BG)
            ) {
                items(10) {
                    cardView()
                }
            }
            // Ensure Spacer is only used if needed for spacing above the button
        }
    })
}

@Composable
fun TopBar() {
    Column() {
        Text(
            text = stringResource(id = R.string.app_name),
            style = Typography.headlineLarge,
            color = Color.White
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

}

