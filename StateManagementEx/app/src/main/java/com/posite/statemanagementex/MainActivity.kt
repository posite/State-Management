package com.posite.statemanagementex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.mvrx.Mavericks
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.compose.mavericksViewModel
import com.posite.statemanagementex.ui.theme.StateManagementExTheme

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mavericks.initialize(this)
        enableEdgeToEdge()
        setContent {
            StateManagementExTheme {
                viewModel = mavericksViewModel<MainViewModel, CountState>()
                val count by viewModel.collectAsState { it.count }
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Counter(
                        count,
                        Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }

    @Composable
    fun Counter(count: Int, modifier: Modifier) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Count: $count", fontSize = 24.sp)
            VerticalDivider(modifier = Modifier.height(8.dp))
            Button({ viewModel.incrementCount() }) {
                Text(text = "Click!", fontSize = 24.sp)
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    StateManagementExTheme {
//        Greeting("Android")
//    }
//}