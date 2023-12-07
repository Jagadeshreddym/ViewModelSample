package com.example.viewmodelsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.viewmodelsample.ui.theme.ViewModelSampleTheme

class MainActivity : ComponentActivity() {
    private val viewModel: MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewModelSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyScreen(viewModel = viewModel)
                }
            }
        }
    }
}



@Composable
fun MyScreen(viewModel: MyViewModel)
{
    val counterState = viewModel.counter
    Column(modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Counter: ${counterState.value}")
        Button(onClick = {viewModel.incrementCounter()}) {
            Text("Increment")
        }
        Button(onClick = {viewModel.decrementCounter()}) {
            Text(text = "Decrement")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ViewModelSampleTheme {
        val previewViewModel = MyViewModel()
        MyScreen(viewModel = previewViewModel)

    }
}