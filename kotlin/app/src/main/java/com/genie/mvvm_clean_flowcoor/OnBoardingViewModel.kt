package com.genie.mvvm_clean_flowcoor

import androidx.hilt.Assisted
import androidx.lifecycle.ViewModel
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.SavedStateHandle

class OnBoardingViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel()
