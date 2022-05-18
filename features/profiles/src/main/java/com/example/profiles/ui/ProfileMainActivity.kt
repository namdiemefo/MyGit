package com.example.profiles.ui

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.example.profiles_ui.presentation.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileMainActivity: ComponentActivity() {

    val profileViewModel by viewModels<ProfileViewModel>()

}