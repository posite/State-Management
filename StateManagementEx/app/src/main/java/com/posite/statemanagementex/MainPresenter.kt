package com.posite.statemanagementex

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import javax.inject.Inject

class MainPresenter @Inject constructor(private val repository: MainRepository) :
    Presenter<MainScreen.State> {
    @Composable
    override fun present(): MainScreen.State {
        var favorites by remember { mutableIntStateOf(repository.initState()) }
        return MainScreen.State(favorites) { favorites++ }
    }

    class Factory @Inject constructor(private val repository: MainRepository) : Presenter.Factory {
        override fun create(
            screen: Screen,
            navigator: Navigator,
            context: CircuitContext
        ): Presenter<*> {
            return MainPresenter(repository)
        }
    }
}