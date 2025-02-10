package com.posite.statemanagementex

import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import com.airbnb.mvrx.hilt.MavericksViewModelComponent
import com.airbnb.mvrx.hilt.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.multibindings.IntoMap

@Module
@InstallIn(MavericksViewModelComponent::class)
interface DiModule {

//    @Binds
//    @Singleton
//    fun provideMainRepository(mainRepository: MainRepository): MainRepository

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun exampleViewModelFactory(mainViewModelFactory: MainViewModel.MainViewModelFactory): AssistedViewModelFactory<*, *>
}