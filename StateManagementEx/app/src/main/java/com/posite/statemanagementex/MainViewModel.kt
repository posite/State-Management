package com.posite.statemanagementex

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import com.airbnb.mvrx.hilt.hiltMavericksViewModelFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class MainViewModel @AssistedInject constructor(
    @Assisted initialState: CountState,
    private val mainRepository: MainRepository
) :
    MavericksViewModel<CountState>(initialState) {

    init {
        setState { mainRepository.initCount() }
    }

    @AssistedFactory
    interface MainViewModelFactory : AssistedViewModelFactory<MainViewModel, CountState> {
        override fun create(initialState: CountState): MainViewModel
    }


    fun incrementCount() {
        setState { copy(count = count + 1) }
    }

    companion object :
        MavericksViewModelFactory<MainViewModel, CountState> by hiltMavericksViewModelFactory()
}