package com.hj.compose.basiccodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hj.compose.basiccodelab.ui.theme.BasicCodelabTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicCodelabTheme {
                // A surface container using the 'background' color from the theme
               MyApp()
            }
        }
    }
}
@Composable
private fun MyApp(names : List<String> = listOf("World", "Compose")){
    Column {
        for(name in names) {
            Greeting(name = name)
        }

    }

}
@Composable
fun Greeting(name: String) {
    val expanded = remember { mutableStateOf(false)}
    val extraPadding  = if(expanded.value) 48.dp else 8.dp
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp , horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)) {
                Text(text = "Hello,")
                Text(text = name)
            }
            OutlinedButton(
                onClick = { expanded.value = !expanded.value} // later
            ){
                Text(if(expanded.value) "Show less" else "Show more")
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    BasicCodelabTheme {
       MyApp()
    }
}