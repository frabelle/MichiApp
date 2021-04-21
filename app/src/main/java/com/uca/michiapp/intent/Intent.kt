package com.uca.michiapp.intent

sealed class Intent {
    object GetCatEvent: Intent()
    object None: Intent()
}