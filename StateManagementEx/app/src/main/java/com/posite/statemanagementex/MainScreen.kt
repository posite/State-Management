package com.posite.statemanagementex

import com.slack.circuit.runtime.CircuitUiEvent
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.screen.Screen
import kotlinx.parcelize.Parcelize

@Parcelize
data object MainScreen : Screen {
    data class State(val count: Int = 0, val event: () -> Unit) : CircuitUiState

    sealed interface Event : CircuitUiEvent {
        data object OnButtonClick : Event
    }
}
