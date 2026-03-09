package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background               // добавили
import androidx.compose.foundation.layout.Box              // добавили
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment                         // добавили
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color                   // добавили
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp                          // добавили (для padding)
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)  // передаём отступы
                    )
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()           // Box занимает всё доступное место (с учётом переданных отступов)
    ) {
        Text(
            text = "Hello $name!",
            modifier = Modifier
                .align(Alignment.TopStart)   // вверху слева
                .padding(8.dp)                // отступ внутри фона
                .background(Color.Red)         // красный фон
        )
        Text(
            text = "Hello again!",
            modifier = Modifier
                .align(Alignment.Center)      // по центру
                .padding(8.dp)
                .background(Color.Green)       // зелёный фон
        )
        Text(
            text = "Goodbye!",
            modifier = Modifier
                .align(Alignment.BottomEnd)   // внизу справа
                .padding(8.dp)
                .background(Color.Blue)        // синий фон
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}