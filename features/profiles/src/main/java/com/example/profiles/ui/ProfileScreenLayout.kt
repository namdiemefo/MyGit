package com.example.profiles.ui

import QueryRequest
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.profiles_ui.presentation.ProfileViewModel

@[Composable ExperimentalMaterialApi ExperimentalFoundationApi ExperimentalComposeUiApi]
fun ProfileScreen(
    profileViewModel: ProfileViewModel
) {

    val items = profileViewModel.getAllProfiles(page = QueryRequest(page = 1, query = "p"))
    
    Scaffold(
        backgroundColor = Color.White,
        content = {
            ProfileList(items)
        }
    )
    
}

@Composable
fun ProfileList(items: Unit) {

    
    
}

@Composable
private fun UserRow(user:User,onUserClick: (User) -> Unit) {
    Row(modifier = Modifier.clickable(onClick = { onUserClick(user) }).fillMaxWidth().padding(8.dp)) {

        val imageModifier = Modifier.preferredSize(46.dp).clip(shape = CircleShape)
        val image = imageResource(id = R.drawable.header)

        Image(asset = image,modifier = imageModifier,contentScale = ContentScale.Crop)

        Column (modifier = Modifier.padding(start = 8.dp).gravity(Alignment.CenterVertically)){
            Text(text = user.name, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.h6)
            ProvideEmphasis(EmphasisAmbient.current.medium) {
                Text(text = user.bio,style = MaterialTheme.typography.body2)
            }

        }
    }
}



