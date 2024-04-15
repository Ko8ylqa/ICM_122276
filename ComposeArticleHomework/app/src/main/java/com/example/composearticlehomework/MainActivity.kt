package com.example.composearticlehomework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.Image
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticlehomework.ui.theme.ComposeArticleHomeworkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleHomeworkTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        GreetingImage()
                        GreetingText(
                            heading = stringResource(R.string.heading),
                            paragraph1 = stringResource(R.string.paragraph1),
                            paragraph2 = stringResource(R.string.paragraph2),
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun GreetingText(heading: String,paragraph1: String, paragraph2: String,modifier: Modifier = Modifier) {
    Column (
       verticalArrangement = Arrangement.Top,
        modifier = modifier,
    ){
        Text(
            text = heading,
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp,
        )
        Text(
            text = paragraph1,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = paragraph2,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun GreetingImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Fit,
        )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleHomeworkTheme {
        GreetingText(heading = "Jetpack Compose tutorial",
            paragraph1 = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
            paragraph2 = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",
            )
    }
}