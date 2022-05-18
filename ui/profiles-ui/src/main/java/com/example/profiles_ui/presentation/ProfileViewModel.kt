package com.example.profiles_ui.presentation

import QueryRequest
import androidx.lifecycle.ViewModel

abstract class ProfileViewModel : ViewModel() {

    abstract fun getAllProfiles(page: QueryRequest)

}