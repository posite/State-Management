package com.posite.statemanagementex

sealed interface MainIntent {
    data object OnIncrementClick : MainIntent
}