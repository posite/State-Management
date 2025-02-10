package com.posite.statemanagementex

import javax.inject.Inject

class MainRepository @Inject constructor() {
    fun initCount() = CountState(10)
}