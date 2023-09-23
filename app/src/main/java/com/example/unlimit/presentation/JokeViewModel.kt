package com.example.unlimit.presentation

import androidx.lifecycle.viewModelScope
import com.example.unlimit.core.onceIn
import com.example.unlimit.domain.JokeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.retry
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class JokeUIEvent() : Event.UIEvent() {
    object GetJoke : JokeUIEvent()
}

@HiltViewModel
class JokeViewModel @Inject constructor(private val useCase: JokeUseCase) :
    EventHandlerViewModel<JokeUIEvent>() {

    private val _jokesState = MutableStateFlow(emptyList<String>())
    val jokesState = _jokesState.asStateFlow()
    override fun handleEvent(event: JokeUIEvent) {
        when (event) {
            JokeUIEvent.GetJoke -> {
                fetchJoke()
            }
        }
    }


    private fun fetchJoke() {
        viewModelScope.launch {
            while(true) {
                useCase.getJoke()
                    .flowOn(Dispatchers.IO)
                    .onEach { result ->
                        result.onSuccess { joke ->
                            println("success:: $joke")
                            if (joke != null) {
                                _jokesState.update {
                                    it.plus(joke)
                                }
                            }
                        }
                        result.onFailure {
                            println("failed:: ${it.message}")
                        }

                    }.onceIn(viewModelScope)
                delay(5000)
            }
        }
    }
}

