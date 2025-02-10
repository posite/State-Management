package com.posite.statemanagementex

import com.airbnb.mvrx.MavericksState

data class CountState (
    val count: Int = 0
): MavericksState {

}