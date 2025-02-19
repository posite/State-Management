package com.posite.statemanagementex

import javax.inject.Inject

class MainRepository @Inject constructor() {
    fun initCount() = CountState(10)
    fun initState() = 10
    fun initMainState() = MainState(10)
}