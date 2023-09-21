package com.example.unlimit.presentation

import androidx.lifecycle.ViewModel
import com.example.unlimit.domain.JokeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class JokeViewModel @Inject constructor(val useCase: JokeUseCase) : ViewModel() {
}