package com.posite.statemanagementex

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext

class MainViewModel(initialState: CountState) : MavericksViewModel<CountState>(initialState) {

    fun incrementCount() {
        setState { copy(count = count + 1) }
    }


    companion object : MavericksViewModelFactory<MainViewModel, CountState> {
        override fun initialState(viewModelContext: ViewModelContext): CountState {
            return CountState(0)
        }

        override fun create(viewModelContext: ViewModelContext, state: CountState): MainViewModel {
            return MainViewModel(state)
        }
    }
}