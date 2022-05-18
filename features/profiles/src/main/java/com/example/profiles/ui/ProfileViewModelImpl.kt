package com.example.profiles.ui

import GetAllProfilesUseCase
import QueryRequest
import androidx.lifecycle.viewModelScope
import com.example.profiles_ui.presentation.ProfileViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModelImpl
@Inject
constructor(private val getAllProfilesUseCase: GetAllProfilesUseCase) : ProfileViewModel() {

     override fun getAllProfiles(page: QueryRequest) {
         viewModelScope.launch {
             getAllProfilesUseCase.invoke(page = page).collect {

             }
         }
    }


}
