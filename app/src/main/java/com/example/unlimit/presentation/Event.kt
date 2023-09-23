package com.example.unlimit.presentation

import androidx.lifecycle.ViewModel

sealed class Event {
    abstract class UIEvent() : Event()
}

abstract class EventHandlerViewModel<in EVENT : Event.UIEvent> : ViewModel() {
    abstract fun handleEvent(event: EVENT)
}