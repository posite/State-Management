package com.posite.statemanagementex

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class MainOrbitViewModel @Inject constructor(private val mainRepository: MainRepository) :
    ViewModel(), ContainerHost<MainState, MainSideEffect> {

    override val container: Container<MainState, MainSideEffect> =
        container(mainRepository.initMainState())

    fun processIntent(intent: MainIntent) {
        when (intent) {
            is MainIntent.OnIncrementClick -> incrementCount()
        }
    }

    private fun incrementCount() = intent {
        reduce {
            state.copy(count = state.count + 1)
        }
        postSideEffect(MainSideEffect.Toast("Incremented : ${state.count}"))
        Log.d("MainOrbitViewModel", "state.count: ${state.count}")
    }
}