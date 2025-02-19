package com.posite.statemanagementex

sealed interface MainSideEffect {
    data class Toast(val message: String) : MainSideEffect
}