package com.posite.statemanagementex

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.posite.statemanagementex.ui.theme.StateManagementExTheme
import dagger.hilt.android.AndroidEntryPoint
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@AndroidEntryPoint
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class MainActivity : ComponentActivity() {

    //@Inject
    //lateinit var factory: MainPresenter.Factory

    private val viewModel: MainOrbitViewModel by viewModels<MainOrbitViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Mavericks.initialize(this)
        //enableEdgeToEdge()
        //val circuit = Circuit.Builder()
        //.addPresenterFactory(factory)
        //.addUi<MainScreen, MainScreen.State>({ state, modifier -> Counter(state, modifier) })
        //.build()
        setContent {
            StateManagementExTheme {
                /*viewModel = mavericksViewModel<MainViewModel, CountState>()
                val count by viewModel.collectAsState { it.count }
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Counter(
                        count,
                        Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }*/
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    //CircuitCompositionLocals(circuit) {
                    //CircuitContent(MainScreen)
                    //}
                    val state by viewModel.collectAsState()
                    viewModel.collectSideEffect { handleSideEffect(it) }
                    Counter(
                        state.count,
                        { viewModel.processIntent(MainIntent.OnIncrementClick) },
                        modifier = Modifier.fillMaxSize()
                    )
                }

            }
        }
    }

    @Composable
    fun Counter(count: Int, onButtonClick: () -> Unit, modifier: Modifier) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Count: $count", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Button({ onButtonClick() }) {
                Text(text = "Click!", fontSize = 24.sp)
            }
        }
    }

    private fun handleSideEffect(sideEffect: MainSideEffect) {
        when (sideEffect) {
            is MainSideEffect.Toast -> Log.d("count", sideEffect.message)
        }
    }
}

//@CircuitInject(MainScreen::class, ActivityRetainedComponent::class)
//@Composable
//fun Counter(state: MainScreen.State, modifier: Modifier) {
//    Column(
//        modifier = modifier,
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(text = "Count: ${state.count}", fontSize = 24.sp)
//        Spacer(modifier = Modifier.height(8.dp))
//        Button({ state.event() }) {
//            Text(text = "Click!", fontSize = 24.sp)
//        }
//    }
//}