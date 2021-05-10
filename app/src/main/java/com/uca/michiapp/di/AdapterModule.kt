package com.uca.michiapp.di

import android.app.Application
import android.speech.tts.TextToSpeech
import android.widget.AdapterView
import com.uca.michiapp.ui.fragments.MainFragment
import com.uca.michiapp.utils.AdapterBreed
import com.uca.michiapp.utils.AdapterCats
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AdapterModule {

    @Singleton
    @Provides
    fun provideAdapterGenres(application: Application): AdapterCats {
        return AdapterCats()
    }

    @Singleton
    @Provides
    fun provideAdapterBreeds(application: Application): AdapterBreed {
        return AdapterBreed()
    }
}